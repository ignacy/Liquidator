package GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

class TextPanel {
    private JScrollPane scroll;
    private Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    private StyledDocument document;
    private JTextPane panel;

    TextPanel(String initialContent, Color background) {
        panel = new JTextPane();
        panel.setMargin(new Insets(12, 12,12,12));
        panel.setBackground(background);

        document = panel.getStyledDocument();
        document.addStyle("default", defaultStyle);

        StyleConstants.setFontFamily(defaultStyle, "SansSerif");
        StyleConstants.setFontSize(defaultStyle, 20);
        StyleConstants.setForeground(defaultStyle, new Color(34,34,34));

        try {
            document.insertString(document.getLength(), initialContent, document.getStyle("default"));
        } catch (BadLocationException ble) {
            System.err.println(ble.getMessage());
        }
        scroll = new JScrollPane(panel);
    }

    Style getDefaultStyle() {
        return defaultStyle;
    }

    String getText() {
        try {
            return document.getText(0, document.getLength());
        } catch (BadLocationException ble) {
            return "";
        }
    }

    JScrollPane getScroll() {
        return scroll;
    }

    void makeReadonly() {
        panel.setEditable(false);
    }
}
