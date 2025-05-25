package j.advanced.l5.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import j.advanced.l5.helpers.RodzajWiadomosciEnum;
import j.advanced.l5.helpers.Wiadomosc;

public class ServerClient extends Thread {
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public ServerClient(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
                true);
    }

    public void zamknij() {
        try {
            writer.close();
        } catch (Exception e1) {
        }
        try {
            reader.close();
        } catch (Exception e2) {
        }
        try {
            socket.close();
        } catch (Exception e3) {
        }
    }

    public PrintWriter getWriter() {
        return writer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String wiadomoscString = reader.readLine();
                Wiadomosc wiadomosc = Wiadomosc.deserializuj(wiadomoscString);

                System.out.println(wiadomoscString);
                switch (wiadomosc.getRodzajWiadomosci()) {
                    case RodzajWiadomosciEnum.wiadomosc:
                        for (ServerClient klient : ChatServer.klienci) {
                            klient.getWriter().write(wiadomoscString);
                        }
                        break;

                    default:
                        break;
                }

            }
        } catch (Exception e) {
        }
    }
}
