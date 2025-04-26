// Source code is decompiled from a .class file using FernFlower decompiler.
package j.advanced.homework.l2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class ParaSlow {
    String polish;
    String english;

    public ParaSlow(String polish, String english) {
        this.polish = polish;
        this.english = english;
    }
}

class FlashCards extends JFrame implements ActionListener {
    private JTextField englishWord;
    private JTextField polishWord;
    private JButton showNextWordButton;

    private List<ParaSlow> wordPairs = new ArrayList<>();
    private int currentIndex = 0;

    public FlashCards() {
        init();
    }

    public void init() {
        setTitle("Prezentacja słówek angielskich");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        englishWord = new JTextField();
        polishWord = new JTextField();
        showNextWordButton = new JButton("Pokaż następne słówko");

        englishWord.setEditable(false);
        polishWord.setEditable(false);

        polishWord.setFont(new Font("Arial", Font.BOLD, 24));
        englishWord.setFont(new Font("Arial", Font.BOLD, 24));

        polishWord.setHorizontalAlignment(JTextField.CENTER);
        englishWord.setHorizontalAlignment(JTextField.CENTER);

        JPanel labelsPanel = new JPanel(new GridLayout(1, 2));
        labelsPanel.add(new JLabel("Po angielsku", SwingConstants.CENTER));
        labelsPanel.add(new JLabel("Po polsku", SwingConstants.CENTER));

        JPanel textPanel = new JPanel(new GridLayout(1, 2));
        textPanel.add(englishWord);
        textPanel.add(polishWord);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(labelsPanel, BorderLayout.NORTH);
        centerPanel.add(textPanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        add(showNextWordButton, BorderLayout.SOUTH);

        showNextWordButton.addActionListener(this);

        // Adding example word pairs
        wordPairs.add(new ParaSlow("kot", "cat"));
        wordPairs.add(new ParaSlow("pies", "dog"));
        wordPairs.add(new ParaSlow("dom", "house"));
        wordPairs.add(new ParaSlow("drzewo", "tree"));
        wordPairs.add(new ParaSlow("samochód", "car"));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ParaSlow para = wordPairs.get(currentIndex);
        polishWord.setText(para.polish);
        englishWord.setText(para.english);
        currentIndex++;
        if (currentIndex >= wordPairs.size()) {
            currentIndex = 0; // start from beginning
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new FlashCards();
    }

}