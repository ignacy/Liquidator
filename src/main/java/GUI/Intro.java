package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Sekcja wprowadzająca z informacjami i dokumentacją.
 */
class Intro {
        private JLabel label;
        private final String documentationLink = "https://shopify.github.io/liquid/basics/introduction/";

        Intro() {
            label = new JLabel();
            label.setText(getLabelText());
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setFont(new Font("Sans Serif", Font.PLAIN, 18));
            label.setForeground(Color.GRAY);
            label.setAlignmentX(0.5f);

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI(documentationLink));
                    } catch (URISyntaxException | IOException ex) {
                        // Obsłużyć
                    }
                }
            });
        }

        JLabel getLabel() {
            return label;
        }

        private String getLabelText() {
            return "<html>Edytor umożliwia tworzenie szablonów Liquid z podglądem na żywo. \n" +
                   "Pełna dokumenatcja samych szablonów jest dostępna, wraz z przykładami \n" +
                   "<a href=\"" + documentationLink + "\">pod tym adresem </a></html>";
        }
}
