package j.advanced.l5.views;

import j.advanced.l5.helpers.Message;
import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;

import static j.advanced.l5.helpers.Configure.IP;
import static j.advanced.l5.helpers.Configure.PORT;
import static j.advanced.l5.helpers.Configure.RodzajWiadmosci.PODAJ_NAZWE;
import static j.advanced.l5.helpers.Configure.RodzajWiadmosci.Message;

public class ChatView extends javax.swing.JPanel {

    public ChatView() throws IOException {
        socket = new Socket(IP, PORT);
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        new ClientThread().start();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        inputTextField = new javax.swing.JTextField();
        wyslijButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        wyslijButton.setText("Wyślij");
        wyslijButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyslijButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inputTextField)
                                                .addGap(18, 18, 18)
                                                .addComponent(wyslijButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 27, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wyslijButton))
                                .addGap(26, 26, 26)));
    }// </editor-fold>

    private void wyslijButtonActionPerformed(java.awt.event.ActionEvent evt) {
        writer.println(new Message(Message, inputTextField.getText()).serializuj());
        inputTextField.setText("");
        System.out.println("Wysylam");
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField inputTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton wyslijButton;
    public Socket socket;
    public BufferedReader reader;
    public PrintWriter writer;

    public class ClientThread extends Thread {

        @Override
        public void run() {
            try {
                String userInput = JOptionPane.showInputDialog("Podaj swoją nazwę:");
                if (userInput == null || userInput.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nazwa nie może być pusta!", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                writer.println(new Message(PODAJ_NAZWE, userInput).serializuj());

                while (true) {
                    String MessageString = reader.readLine();
                    Message Message = Message.deserializuj(MessageString);
                    System.out.println("Klient: " + MessageString);
                    switch (Message.getRodzajMessagei()) {
                        case Message: {
                            jTextArea1.append(Message.getZawartosc() + "\n");
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
    }
}
