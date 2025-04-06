package j.advanced.l2;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class ColorMixer extends JFrame {
    protected JSlider red;
    protected JSlider green;
    protected JSlider blue;
    private JPanel colorDisplay;

    public ColorMixer() {
        init();
    }

    public void init() {
        setTitle("Simple Calculator");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        red = new JSlider(0, 255, 0);
        green = new JSlider(0, 255, 0);
        blue = new JSlider(0, 255, 0);

        colorDisplay = new JPanel();
        colorDisplay.setPreferredSize(new java.awt.Dimension(800, 400));

        add(new JLabel("Red"));
        add(red);
        add(new JLabel("Green"));
        add(green);
        add(new JLabel("Blue"));
        add(blue);
        add(colorDisplay);

        ColorMixerListener listener = new ColorMixerListener(this);
        red.addChangeListener(listener);
        green.addChangeListener(listener);
        blue.addChangeListener(listener);

        setVisible(true);
    }

    public void updateColor(int redValue, int greenValue, int blueValue) {
        colorDisplay.setBackground(new Color(redValue, greenValue, blueValue));
    }
}
