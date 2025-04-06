package j.advanced.l2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.*;

public class SimpleCalculator extends JFrame {

    private JButton minusButton;
    private JButton plusButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private TextField operandOneField;
    private TextField operandTwoField;
    private TextField resultTextField;

    public SimpleCalculator() {
        init();
    }

    public void init() {
        setTitle("Simple Calculator");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divisionButton = new JButton("/");
        operandOneField = new TextField(3);
        operandTwoField = new TextField(3);
        resultTextField = new TextField(3);
        resultTextField.setEnabled(false);

        add(new JLabel("Operand 1: "));
        add(operandOneField);
        add(new JLabel("Operand 2: "));
        add(operandTwoField);
        add(minusButton);
        add(plusButton);
        add(multiplyButton);
        add(divisionButton);
        add(new JLabel("Result: "));
        add(resultTextField);

        setVisible(true);
    }
}
