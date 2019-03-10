package GUI;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

class TextPanel {
    private JScrollPane scroll;
    private StyledDocument document;
    private JTextPane panel;

    TextPanel(String initialContent, Color background) {
        panel = new JTextPane();
        document = panel.getStyledDocument();
        setupLooks(background);
        setText(initialContent);
        scroll = new JScrollPane(panel);
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

    JTextPane getPane() {
        return panel;
    }

    void makeReadonly() {
        panel.setEditable(false);
    }

    private void setupLooks(Color background) {
        panel.setMargin(new Insets(12, 12,12,12));
        panel.setBackground(background);

        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        document.addStyle("default", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Monospaced");
        StyleConstants.setFontSize(defaultStyle, 22);
        StyleConstants.setForeground(defaultStyle, new Color(0, 0, 1));
    }

    public void setText(String content) {
        try {
            document.insertString(document.getLength(), content, document.getStyle("default"));
        } catch (BadLocationException ble) {
            System.err.println(ble.getMessage());
        }
    }

    public void clearText() {
        try {
            document.remove(0, document.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
