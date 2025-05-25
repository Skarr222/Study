package j.advanced.l5;

class Main {
    public static void main(String[] args) {
        // Create and display the TimerView
        javax.swing.SwingUtilities.invokeLater(() -> {
            j.advanced.l5.views.TimerView timerView = new j.advanced.l5.views.TimerView();
            timerView.setVisible(true);
        });
    }
}