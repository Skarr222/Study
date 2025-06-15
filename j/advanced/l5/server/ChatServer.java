package j.advanced.l5.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static j.advanced.l5.helpers.Configuration.PORT;

public class ChatServer extends Thread {
    private ServerSocket serverSocket;
    public static List<ServerClient> klienci;

    public ChatServer() throws IOException {
        this.klienci = new ArrayList<>();
        this.serverSocket = new ServerSocket(PORT);
    }

    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                ServerClient client = new ServerClient(socket);
                client.start();
                klienci.add(client);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            try {
                serverSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
