package j.advanced.l5;

import j.advanced.l5.server.ChatServer;
import j.advanced.l5.views.ChatView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JFrame frame = new JFrame("Chat");
            ChatView chatView = new ChatView();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(chatView);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        chatView.writer.close();
                    } catch (Exception e1) {
                    }
                    try {
                        chatView.reader.close();

                    } catch (Exception e2) {
                    }
                    try {
                        chatView.socket.close();
                    } catch (Exception e3) {
                    }
                }
            });
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
