package j.advanced.homework.pd3;

import j.advanced.homework.pd3.client.WordGuessClient;
import j.advanced.homework.pd3.server.WordGuessServer;

public class Main {
    public static void main(String[] args) {
        try {
            Thread serverThread = new Thread(() -> {
                try {
                    WordGuessServer.main(new String[0]);
                } catch (Exception e) {
                    System.err.println("Błąd podczas uruchamiania serwera:");
                    e.printStackTrace();
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();

            Thread.sleep(1000);

            Thread client1 = new Thread(() -> {
                try {
                    WordGuessClient.main(new String[0]);
                } catch (Exception e) {
                    System.err.println("Błąd klienta 1:");
                    e.printStackTrace();
                }
            });

            Thread client2 = new Thread(() -> {
                try {
                    WordGuessClient.main(new String[0]);
                } catch (Exception e) {
                    System.err.println("Błąd klienta 2:");
                    e.printStackTrace();
                }
            });

            client1.start();
            client2.start();

            // Thread client3 = new Thread(() -> {
            // try {
            // WordGuessClient.main(new String[0]);
            // } catch (Exception e) {
            // System.err.println("Błąd klienta 3:");
            // e.printStackTrace();
            // }
            // });
            // Thread client4 = new Thread(() -> {
            // try {
            // WordGuessClient.main(new String[0]);
            // } catch (Exception e) {
            // System.err.println("Błąd klienta 4:");
            // e.printStackTrace();
            // }
            // });

            // client3.start();
            // client4.start();

        } catch (Exception e) {
            System.err.println("Błąd w metodzie main:");
            e.printStackTrace();
        }
    }
}
