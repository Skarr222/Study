package j.advanced.homework.pd3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class WordGuessServer {
    private static final int PORT = 12345; // Port serwera
    private static Queue<PlayerHandler> waitingPlayers = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("[SERVER] Serwer uruchomiony na porcie " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("[SERVER] Nowe połączenie: " + clientSocket);
                PlayerHandler player = new PlayerHandler(clientSocket);

                synchronized (waitingPlayers) {
                    waitingPlayers.add(player);
                    if (waitingPlayers.size() >= 2) {
                        PlayerHandler player1 = waitingPlayers.poll();
                        PlayerHandler player2 = waitingPlayers.poll();
                        GameRoom gameRoom = new GameRoom(player1, player2);
                        new Thread(gameRoom).start();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}