package GUI;

import javax.swing.*;
import java.awt.*;

public class ErrorDetails {
    private JLabel label;

    ErrorDetails() {
        label = new JLabel();
        label.setText("");
        label.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        label.setFont(new Font("Sans Serif", Font.BOLD, 18));
        label.setForeground(Color.RED);
        label.setAlignmentX(0.5f);
    }

    JLabel getLabel() {
        return this.label;
    }
}
