package j.advanced.l5.views;

import java.time.Instant;

import j.advanced.l5.thread.StoperThread;

public class TimerView extends javax.swing.JFrame {
    private javax.swing.Timer guiUpdateTimer;
    private Instant startTime;
    private double initialDurationSeconds;
    private volatile boolean isRunning = false;

    public TimerView() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        stoperTextField = new javax.swing.JTextField();
        buttonStart = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        buttonZamknij = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stoperTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        buttonStart.setText("Start");
        buttonStart.setToolTipText("");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonStop.setText("Stop");
        buttonStop.setToolTipText("");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        buttonZamknij.setText("Zamknij");
        buttonZamknij.setToolTipText("");
        buttonZamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZamknijActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(buttonStart)
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(stoperTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonStop)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63,
                                                        Short.MAX_VALUE)
                                                .addComponent(buttonZamknij)
                                                .addGap(36, 36, 36)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(stoperTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonStart)
                                        .addComponent(buttonStop)
                                        .addComponent(buttonZamknij))
                                .addContainerGap(167, Short.MAX_VALUE)));

        pack();
    }

    private void buttonZamknijActionPerformed(java.awt.event.ActionEvent evt) {
        int response = javax.swing.JOptionPane.showConfirmDialog(this,
                "Czy na pewno chcesz zamknąć aplikacje?",
                "Potwierdź wyjście",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE);

        if (response == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {
        String text = stoperTextField.getText().trim();

        if (text.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Wprowadź czas w sekundach!", "Błąd",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (timerThread == null || timerThread.isAlive()) {
            try {
                int time = Integer.parseInt(text);
                if (time <= 0) {
                    throw new NumberFormatException();
                }
                timerThread = new StoperThread(stoperTextField);
                timerThread.start();
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Niepoprawna wartość! Wprowadź dodatnią liczbę całkowitą.",
                        "Błąd", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {
        if (timerThread == null && timerThread.isAlive()) {
            timerThread.interrupt();
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimerView().setVisible(true);
            }
        });
    }

    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonStop;
    private javax.swing.JButton buttonZamknij;
    private javax.swing.JTextField stoperTextField;
    private StoperThread timerThread;
}
