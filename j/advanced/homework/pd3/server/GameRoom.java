package j.advanced.homework.pd3.server;

import java.io.IOException;
import java.util.Random;

import j.advanced.homework.pd3.common.MessageTypeEnum;
import j.advanced.homework.pd3.common.Message;

public class GameRoom implements Runnable {
    private PlayerHandler player1;
    private PlayerHandler player2;
    private PlayerHandler chooser;
    private PlayerHandler guesser;
    private String secretWord;
    private final int MAX_ATTEMPTS = 5;
    private final int ROUND_TIME_MS = 60000;

    public GameRoom(PlayerHandler p1, PlayerHandler p2) {
        this.player1 = p1;
        this.player2 = p2;
        player1.setGameRoom(this);
        player2.setGameRoom(this);
    }

    @Override
    public void run() {
        try {
            startNewRound();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startNewRound() throws IOException {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            chooser = player1;
            guesser = player2;
        } else {
            chooser = player2;
            guesser = player1;
        }

        chooser.sendMessage(new Message(MessageTypeEnum.WYBIERZ_SLOWO, "Wybierz słowo do zgadnięcia."));
        guesser.sendMessage(new Message(MessageTypeEnum.INFO, "Oczekiwanie aż przeciwnik wybierze słowo..."));

        String word = chooser.waitForChosenWord();
        if (word == null)
            return;
        secretWord = word.trim().toLowerCase();

        guesser.sendMessage(
                new Message(MessageTypeEnum.ZGADUJ, "Zgaduj słowo. Masz " + MAX_ATTEMPTS + " prób."));
        chooser.sendMessage(new Message(MessageTypeEnum.INFO, "Oczekiwanie na zgadywanie przez przeciwnika..."));

        long startTime = System.currentTimeMillis();
        int attempts = 0;
        boolean hasWon = false;

        while (System.currentTimeMillis() - startTime < ROUND_TIME_MS && attempts < MAX_ATTEMPTS) {
            String guess = guesser.waitForGuess();
            if (guess == null)
                return;
            guess = guess.trim().toLowerCase();
            attempts++;

            if (guess.equals(secretWord)) {
                chooser.sendMessage(new Message(MessageTypeEnum.INFO, "Przeciwnik odgadł słowo: " + guess));
                guesser.sendMessage(new Message(MessageTypeEnum.WYGRANA, "Brawo! Odgadłeś słowo: " + guess));
                hasWon = true;
                break;
            } else {
                if (attempts < MAX_ATTEMPTS) {
                    chooser.sendMessage(new Message(MessageTypeEnum.INFO, "Przeciwnik zgadł: " + guess));
                    guesser.sendMessage(new Message(MessageTypeEnum.BLEDNA_ODPOWIEDZ,
                            "Niepoprawnie. Próba " + attempts + "/" + MAX_ATTEMPTS));
                } else {
                    chooser.sendMessage(
                            new Message(MessageTypeEnum.INFO, "Przeciwnik zgadł: " + guess + " (ostatnia próba)."));
                    guesser.sendMessage(new Message(MessageTypeEnum.BLEDNA_ODPOWIEDZ,
                            "Niepoprawnie. Ostatnia próba " + attempts + "/" + MAX_ATTEMPTS));
                }
            }
        }

        if (hasWon) {
        } else if (System.currentTimeMillis() - startTime >= ROUND_TIME_MS) {
            guesser.sendMessage(
                    new Message(MessageTypeEnum.PRZEGRANA, "Przekroczono limit czasu. Hasło to: " + secretWord));
            chooser.sendMessage(new Message(MessageTypeEnum.INFO, "Przeciwnik nie odgadł hasła w wyznaczonym czasie."));
        } else {
            guesser.sendMessage(
                    new Message(MessageTypeEnum.PRZEGRANA, "Przekroczono limit prób. Hasło to: " + secretWord));
            chooser.sendMessage(new Message(MessageTypeEnum.INFO, "Przeciwnik nie odgadł hasła."));
        }

        player1.sendMessage(
                new Message(MessageTypeEnum.ZAPYTANIE_NOWA_GRA, "Czy chcesz zagrać ponownie? (tak/nie)"));
        player2.sendMessage(
                new Message(MessageTypeEnum.ZAPYTANIE_NOWA_GRA, "Czy chcesz zagrać ponownie? (tak/nie)"));

        boolean p1Wants = player1.waitForReplayDecision();
        boolean p2Wants = player2.waitForReplayDecision();

        if (p1Wants && p2Wants) {
            startNewRound();
        } else {
            player1.sendMessage(new Message(MessageTypeEnum.INFO, "Gra zakończona."));
            player2.sendMessage(new Message(MessageTypeEnum.INFO, "Gra zakończona."));
            player1.close();
            player2.close();
        }
    }
}
