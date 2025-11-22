package j.advanced.homework.pd3.client;

import j.advanced.homework.pd3.common.Message;

import java.io.*;
import java.net.Socket;

public class WordGuessClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private WordGuessView view;

    public WordGuessClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            view = new WordGuessView(this);
            new Thread(this::listen).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        try {
            while (true) {
                Message msg = (Message) in.readObject();
                switch (msg.getType()) {
                    case INFO:
                    case BLEDNA_ODPOWIEDZ:
                    case WYGRANA:
                    case PRZEGRANA:
                        view.showMessage(msg.getContent());
                        break;
                    case WYBIERZ_SLOWO:
                        view.promptForWord();
                        break;
                    case ZGADUJ:
                        view.promptForGuess();
                        break;
                    case ZAPYTANIE_NOWA_GRA:
                        view.askReplay();
                        break;
                    case SLOWO_DO_ZGADNIECIA:
                        view.showMessage("Słowo do zgadnięcia: " + msg.getContent());
                        break;
                }
            }
        } catch (Exception e) {
            view.showMessage("Rozłączono z serwerem.");
        }
    }

    public void sendMessage(Message msg) {
        try {
            out.writeObject(msg);
            out.flush();
        } catch (IOException e) {
            view.showMessage("Błąd wysyłania wiadomości.");
        }
    }

    public static void main(String[] args) {
        new WordGuessClient("localhost", 12345);
    }
}
