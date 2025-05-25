package j.advanced.l5.views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import j.advanced.l5.helpers.Configuration;
import j.advanced.l5.helpers.RodzajWiadomosciEnum;
import j.advanced.l5.helpers.Wiadomosc;

public class ChatView extends javax.swing.JPanel {

    public ChatView() throws IOException {
        this.socket = new Socket(Configuration.IP, Configuration.PORT);
        this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        new ClientThread().start();

        initComponents();

        jTextArea1.append(reader.readLine() + "\n");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        inputTextField = new javax.swing.JTextField();
        wyslijButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane1.setEnabled(false);

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
    }

    private void wyslijButtonActionPerformed(java.awt.event.ActionEvent evt) {
        writer.println(new Wiadomosc(RodzajWiadomosciEnum.wiadomosc, inputTextField.getText()).serializuj());
        inputTextField.setText("");
    }

    private javax.swing.JTextField inputTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton wyslijButton;
    public Socket socket;
    public BufferedReader reader;
    public PrintWriter writer;

    class ClientThread extends Thread {

        public ClientThread() {

        }

        @Override
        public void run() {
            try {
                while (true) {
                    String wiadomoscString = reader.readLine();
                    Wiadomosc wiadomosc = Wiadomosc.deserializuj(wiadomoscString);
                    System.out.println("Klient: " + wiadomoscString);

                    switch (wiadomosc.getRodzajWiadomosci()) {
                        case RodzajWiadomosciEnum.wiadomosc:
                            jTextArea1.append(wiadomosc.getZawartosc() + "\n");
                            break;
                        default:
                            break;
                    }

                }
            } catch (Exception e) {
            }
        }
    }
}
