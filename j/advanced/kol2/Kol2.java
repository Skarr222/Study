
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

class Zapas {
    private String nazwaZapasu;
    private int iloscNaStanie;

    public Zapas(String nazwaZapasu, int iloscNaStanie) {
        this.nazwaZapasu = nazwaZapasu;
        this.iloscNaStanie = iloscNaStanie;
    }

    public synchronized boolean dostarczZapas(int ilosc) {
        if (ilosc > 0) {
            iloscNaStanie += ilosc;
            return true;
        }
        return false;
    }

    public synchronized boolean zuzyjZapas(int ilosc) {
        if (ilosc > 0 && ilosc <= iloscNaStanie) {
            iloscNaStanie -= ilosc;
            return true;
        }
        return false;
    }

    public synchronized int pobierzIloscNaStanie() {
        return iloscNaStanie;
    }

    public String getNazwaZapasu() {
        return nazwaZapasu;
    }
}

class OperacjaRestauracyjna extends Thread {
    private Zapas[] zapasy;
    private int licznikOperacji = 0;
    private boolean przerwany = false;

    public OperacjaRestauracyjna(Zapas[] zapasy) {
        this.zapasy = zapasy;
    }

    public void przerwijWatek() {
        przerwany = true;
        this.interrupt();
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (!przerwany && licznikOperacji < 40) {
            try {
                Thread.sleep((rand.nextInt(4) + 1) * 1000);

                int index = rand.nextInt(zapasy.length);
                Zapas zapas = zapasy[index];
                int ilosc = rand.nextInt(50) + 1;
                boolean dostawa = rand.nextBoolean();

                int stanPrzed = zapas.pobierzIloscNaStanie();
                boolean wynik;

                if (dostawa) {
                    wynik = zapas.dostarczZapas(ilosc);
                    System.out.println("[DOSTAWA] " + zapas.getNazwaZapasu() +
                            ": +" + ilosc + " | Przed: " + stanPrzed +
                            " | Po: " + zapas.pobierzIloscNaStanie() +
                            " | Powiodlo sie? " + (wynik ? " " + "Tak" : "Nie"));
                } else {
                    wynik = zapas.zuzyjZapas(ilosc);
                    System.out.println("[ZUZYCIE] " + zapas.getNazwaZapasu() +
                            ": -" + ilosc + " | Przed: " + stanPrzed +
                            " | Po: " + zapas.pobierzIloscNaStanie() +
                            " | Powiodlo sie? " + (wynik ? " " + "Tak" : "Nie"));
                }

                licznikOperacji++;
            } catch (InterruptedException e) {
                System.out.println("Watek przerwany po " + licznikOperacji + " operacjach.");
                return;
            }
        }
        System.out.println("Watek zakonczyl dzialanie po " + licznikOperacji + " operacjach.");
    }
}

class TextAreaOutputStream extends OutputStream {
    private final JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        SwingUtilities.invokeLater(() -> textArea.append(String.valueOf((char) b)));
    }
}

public class Kol2 extends JFrame {
    private Zapas[] zapasy;
    private java.util.List<OperacjaRestauracyjna> watki = new ArrayList<>();

    public Kol2(String[] argv) {
        setTitle("System Zarządzania Zapasami w Restauracji");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        if (argv.length != 1 || !argv[0].matches("\\d+") || Integer.parseInt(argv[0]) <= 0) {
            JOptionPane.showMessageDialog(this, "Podaj poprawna liczbe watkow jako argument programu.", "Błąd",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        JButton startBtn = new JButton("Start Symulacji");
        startBtn.addActionListener((ActionEvent e) -> startSymulacji(argv));

        JButton stopBtn = new JButton("Zatrzymaj Wszystkie Watki");
        stopBtn.addActionListener((ActionEvent e) -> zatrzymajWatki());

        JPanel panel = new JPanel();
        panel.add(startBtn);
        panel.add(stopBtn);
        add(panel, BorderLayout.SOUTH);

        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        System.setOut(new java.io.PrintStream(new TextAreaOutputStream(logArea)));
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        przygotujZapasy();
    }

    private void przygotujZapasy() {
        zapasy = new Zapas[] {
                new Zapas("Pomidor", 100),
                new Zapas("Ser", 50),
                new Zapas("Karma", 200),
                new Zapas("Mleko", 75)
        };
    }

    private void startSymulacji(String[] argv) {
        for (int i = 0; i < Integer.parseInt(argv[0]); i++) {
            OperacjaRestauracyjna watek = new OperacjaRestauracyjna(zapasy);
            watki.add(watek);
            watek.start();
        }
    }

    private void zatrzymajWatki() {
        for (OperacjaRestauracyjna watek : watki) {
            watek.przerwijWatek();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Kol2(args).setVisible(true));
    }
}
