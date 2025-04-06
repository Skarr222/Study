package j.advanced.l2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.*;

public class ExtendedCalculator extends JFrame {

    private JButton minusButton;
    private JButton plusButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton closeButton;

    private TextField operandOneField;
    private TextField operandTwoField;
    private TextField resultTextField;

    public ExtendedCalculator() {
        init();
    }

    public void init() {
        setTitle("Simple Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(4, 4, 10, 10));

        operandOneField = new TextField(10);
        operandTwoField = new TextField(10);
        resultTextField = new TextField(10);
        resultTextField.setEnabled(false);

        MathOperationListener listener = new MathOperationListener(operandOneField, operandTwoField, resultTextField);

        plusButton = new JButton("+");
        plusButton.addActionListener(listener);
        minusButton = new JButton("-");
        minusButton.addActionListener(listener);
        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(listener);
        divisionButton = new JButton("/");
        divisionButton.addActionListener(listener);
        closeButton = new JButton("Close");

        closeButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, "Czy chcesz zamknąć okno?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        add(new JLabel("Operand 1: "));
        add(new JLabel("Operand 2: "));
        add(new JLabel("Result: "));
        add(operandOneField);
        add(operandTwoField);
        add(resultTextField);
        add(minusButton);
        add(plusButton);
        add(multiplyButton);
        add(divisionButton);
        add(closeButton);

        setVisible(true);
    }

}
