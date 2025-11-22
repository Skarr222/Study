package j.advanced.homework.pd3.client;

import javax.swing.*;

import j.advanced.homework.pd3.common.MessageTypeEnum;
import j.advanced.homework.pd3.common.Message;

import java.awt.*;
import java.awt.event.ActionEvent;

public class WordGuessView extends JFrame {
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton;
    private WordGuessClient client;
    private MessageTypeEnum currentMode;

    public WordGuessView(WordGuessClient client) {
        this.client = client;
        setTitle("Zgadywanie Wyrazów");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setEnabled(false);
        messageArea.setDisabledTextColor(Color.BLACK);
        inputField = new JTextField();
        sendButton = new JButton("Wyślij");

        sendButton.addActionListener(this::handleSend);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleSend(ActionEvent e) {
        String text = inputField.getText().trim();
        if (text.isEmpty())
            return;
        inputField.setText("");

        if (currentMode == MessageTypeEnum.SLOWO_DO_ZGADNIECIA) {
            client.sendMessage(new Message(MessageTypeEnum.SLOWO_DO_ZGADNIECIA, text));
            currentMode = null;
        } else if (currentMode == MessageTypeEnum.PROBA_ZGADNIECIA) {
            client.sendMessage(new Message(MessageTypeEnum.PROBA_ZGADNIECIA, text));
        }
    }

    public void showMessage(String msg) {
        SwingUtilities.invokeLater(() -> messageArea.append(msg + "\n"));
    }

    public void promptForWord() {
        currentMode = MessageTypeEnum.SLOWO_DO_ZGADNIECIA;
        showMessage("Podaj słowo do zgadnięcia:");
    }

    public void promptForGuess() {
        currentMode = MessageTypeEnum.PROBA_ZGADNIECIA;
        showMessage("Zgadnij słowo:");
    }

    public void askReplay() {
        SwingUtilities.invokeLater(() -> {
            int option = JOptionPane.showConfirmDialog(this, "Czy chcesz zagrać ponownie?", "Nowa gra",
                    JOptionPane.YES_NO_OPTION);
            boolean replay = (option == JOptionPane.YES_OPTION);
            client.sendMessage(new Message(MessageTypeEnum.DECYZJA_NOWA_GRA, replay ? "tak" : "nie"));
            currentMode = null; // optional reset between rounds
        });
    }
}