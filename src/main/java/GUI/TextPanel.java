package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import java.awt.*;


// Klasa obsługująca pole tekstowe edytora
class TextPanel {
    private JScrollPane scroll;
    private StyledDocument document;
    private JTextPane panel;

    TextPanel(String initialContent, Color background) {
        panel = new JTextPane();
        document = panel.getStyledDocument();
        setupLooks(background);
        try {
            setText(initialContent);
        } catch (BadLocationException ex) {
            markAsError();
        }
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
        panel.setMargin(new Insets(12, 12, 12, 12));
        panel.setBackground(background);

        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        document.addStyle("default", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Monospaced");
        StyleConstants.setFontSize(defaultStyle, 22);
        StyleConstants.setForeground(defaultStyle, new Color(0, 0, 1));
    }

    void setText(String content) throws BadLocationException {
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        document.insertString(document.getLength(), content, document.getStyle("default"));
    }

    // Dodaje czerwoną otoczkę, by oznaczyć że pole zawiera błąd
    void markAsError() {
        Border border = BorderFactory.createLineBorder(Color.RED);
        panel.setBorder(border);
    }

    void clearText() throws BadLocationException {
        document.remove(0, document.getLength());
    }
}
