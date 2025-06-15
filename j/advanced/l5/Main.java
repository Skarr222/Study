package j.advanced.l5;

import j.advanced.l5.server.ChatServer;
import j.advanced.l5.views.ChatView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
        System.out.println("Serwer gotowy");

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        ChatView chat = new ChatView();
        frame.setContentPane(chat);
        frame.setVisible(true);
        frame.addWindowListener((WindowAdapter) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    chat.writer.close();
                } catch (Exception ex) {

                }
                try {
                    chat.reader.close();
                } catch (IOException exc) {

                }
                try {
                    chat.socket.close();
                } catch (IOException exc) {

                }
            }
        });

        frame = new JFrame();
        frame.setSize(1000, 1000);
        ChatView chat2 = new ChatView();
        frame.setContentPane(chat2);
        frame.setVisible(true);
        frame.addWindowListener((WindowAdapter) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    chat2.writer.close();
                } catch (Exception ex) {

                }
                try {
                    chat2.reader.close();
                } catch (IOException exc) {

                }
                try {
                    chat2.socket.close();
                } catch (IOException exc) {

                }
            }
        });

    }
}
