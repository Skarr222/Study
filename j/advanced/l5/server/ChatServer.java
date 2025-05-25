package j.advanced.l5.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import j.advanced.l5.helpers.Configuration;

public class ChatServer extends Thread {
    private ServerSocket serverSocket;

    public ChatServer() throws IOException {
        this.serverSocket = new ServerSocket(Configuration.PORT);
    }

    @Override
    public void run() {
        try {
            System.out.println("Oczekiwanie na klienta");
            Socket socket = serverSocket.accept();
            System.out.println("Połączono z klientem");
            // * odczytywanie wiadomości od klienta
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // * pisanie wiadomości do klienta
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
                    true);
            writer.println("Witaj na serwerze");
            writer.close();
            reader.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println(e);
            return;
        }
    }

}
