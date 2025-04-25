package j.advanced.homework.l1_2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame implements ActionListener {
    private JButton minusButton;
    private JButton plusButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton deleteButton;

    private JTextField display;

    public Calculator() {
        init();
    }

    public void init() {
        setTitle("Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "C",
                "4", "5", "6", "+",
                "1", "2", "3", "-",
                "0", "", "", "*",
                ".", "+/-", "=", "/",
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

public class Main {
    public static void main(String[] args) {
        new Calculator();
    }

}
