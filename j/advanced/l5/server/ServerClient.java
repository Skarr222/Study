package j.advanced.l5.server;

import static j.advanced.l5.helpers.Configure.RodzajWiadmosci.WIADOMOSC;

import java.io.*;
import java.net.Socket;

import j.advanced.l5.helpers.Wiadomosc;

public class ServerClient extends Thread {
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;
    String nazwa;

    public ServerClient(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void zamknij() {
        writer.close();
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String wiadomoscString = reader.readLine();
                Wiadomosc wiadomosc = Wiadomosc.deserializuj(wiadomoscString);
                switch (wiadomosc.getRodzajWiadomosci()) {
                    case WIADOMOSC: {
                        for (ServerClient klient : ChatServer.klienci) {
                            klient.getWriter().println(
                                    new Wiadomosc(WIADOMOSC, this.nazwa + ": " + wiadomosc.getZawartosc())
                                            .serializuj());
                        }
                        break;
                    }
                    case PODAJ_NAZWE: {
                        this.nazwa = wiadomosc.getZawartosc();
                        for (ServerClient klient : ChatServer.klienci) {
                            klient.getWriter().println(
                                    new Wiadomosc(WIADOMOSC, this.nazwa + " dołączył do czatu").serializuj());

                        }
                        break;
                    }
                    default:
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
