package j.advanced.l2;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathOperationListener implements ActionListener {

    private TextField operandOneField;
    private TextField operandTwoField;
    private TextField result;

    public MathOperationListener(TextField op1, TextField op2, TextField res) {
        this.operandOneField = op1;
        this.operandTwoField = op2;
        this.result = res;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        try {
            switch (value) {
                case "+":
                    this.result.setText(String.valueOf(
                            Integer.parseInt(operandOneField.getText()) + Integer.parseInt(operandTwoField.getText())));
                    break;
                case "-":
                    this.result.setText(String.valueOf(
                            Integer.parseInt(operandOneField.getText()) - Integer.parseInt(operandTwoField.getText())));
                    break;
                case "*":
                    this.result.setText(String.valueOf(
                            Integer.parseInt(operandOneField.getText()) * Integer.parseInt(operandTwoField.getText())));
                    break;
                case "/":
                    this.result.setText(String.valueOf(
                            Float.parseFloat(operandOneField.getText()) / Float.parseFloat(operandTwoField.getText())));
                    break;
                default:
                    break;
            }
        } catch (Exception err) {
            result.setText("N/A");
        }
    }

}
