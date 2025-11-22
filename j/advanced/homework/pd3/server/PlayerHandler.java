package j.advanced.homework.pd3.server;

import java.io.*;
import java.net.Socket;

import j.advanced.homework.pd3.common.MessageTypeEnum;
import j.advanced.homework.pd3.common.Message;

public class PlayerHandler {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private GameRoom gameRoom;

    public PlayerHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
    }

    public void sendMessage(Message msg) throws IOException {
        out.writeObject(msg);
        out.flush();
    }

    public String waitForChosenWord() {
        try {
            while (true) {
                Message msg = (Message) in.readObject();
                if (msg.getType() == MessageTypeEnum.SLOWO_DO_ZGADNIECIA) {
                    return msg.getContent();
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String waitForGuess() {
        try {
            while (true) {
                Message msg = (Message) in.readObject();
                if (msg.getType() == MessageTypeEnum.PROBA_ZGADNIECIA) {
                    return msg.getContent();
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean waitForReplayDecision() {
        try {
            while (true) {
                Message msg = (Message) in.readObject();
                if (msg.getType() == MessageTypeEnum.DECYZJA_NOWA_GRA) {
                    String decision = msg.getContent().trim().toLowerCase();
                    return decision.equals("tak");
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ignored) {
        }
    }
}