package j.advanced.l4.thread;

import javax.swing.JTextField;

public class StoperThread extends Thread {

    private JTextField timeField;

    public StoperThread(JTextField timeField) {
        this.timeField = timeField;
    }

    @Override
    public void run() {
        double time = Integer.parseInt(timeField.getText());
        while (time > 0) {
            time--;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
            timeField.setText(String.valueOf(time));
        }

    }

    public void stopStoper() {

    }

}
