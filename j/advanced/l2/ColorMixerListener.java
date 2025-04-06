package j.advanced.l2;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorMixerListener implements ChangeListener {
    private ColorMixer colorMixer;

    public ColorMixerListener(ColorMixer colorMixer) {
        this.colorMixer = colorMixer;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Get the current values from the sliders
        int redValue = colorMixer.red.getValue();
        int greenValue = colorMixer.green.getValue();
        int blueValue = colorMixer.blue.getValue();

        // Update the color display in ColorMixer
        colorMixer.updateColor(redValue, greenValue, blueValue);
    }

}