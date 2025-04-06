package j.advanced.l2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClosableView extends JFrame {
    public ClosableView() {
        init();
    }

    private void init() {
        setTitle("ExtendedCalc");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        JButton closeButton = new JButton("zamknij");
        add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
    }

    private void close() {
        int option = JOptionPane.showConfirmDialog(this, "Czy chcesz zamknąć okno?", getTitle(),
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

}
