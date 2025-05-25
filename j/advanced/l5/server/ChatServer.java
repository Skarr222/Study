package j.advanced.l5.server;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import j.advanced.l5.helpers.Configuration;

public class ChatServer extends Thread {
    private ServerSocket serverSocket;
    public static List<ServerClient> klienci;

    public ChatServer() throws IOException {
        this.klienci = new ArrayList<>();
        this.serverSocket = new ServerSocket(Configuration.PORT);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                ServerClient serwerClient = new ServerClient(socket);
                serwerClient.start();
                klienci.add(serwerClient);
            }

        } catch (IOException e) {
            System.out.println(e);
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }
    }

}
