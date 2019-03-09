package GUI;

import Liquid.Context;
import Liquid.Renderer;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Główna klasa zajmująca się renderowaniem i obsługą interfejsu użytkownika
 */
public class EditorGUI extends JFrame {
    public EditorGUI(Context context) {
       // Panel w którym edytowany jest tekst szablonu, wypełniony
        // przykładowym tekstem/zachętą
        TextPanel input = new TextPanel("Witaj! \n Możesz edytować ten {{ co }} rezultaty pojawią się {{ gdzie }}", Color.white);

        // Renderujemy zachęte
        Renderer view = new Renderer(input.getText(), context);

        // Panel gdzie widoczne będą rezultaty renderowania szablonów Liquid
        TextPanel output = new TextPanel(view.render(), new Color(208, 232, 203));
        // Zawartość panelu będzie tylko do odczytu
        output.makeReadonly();

        JTextPane pane = input.getPane();

        // implementacja interfejsu KeyListener
        // w celu obsługi klawiszy
        pane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                output.clearText();
                output.setText(new Renderer(pane.getText(), context).render());
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0, 2));
        controlPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        controlPanel.add(output.getScroll());
        controlPanel.add(input.getScroll());

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel link = new JLabel();
        link.setText("<html>Edytor umożliwia tworzenie szablonów Liquid z podglądem na żywo. Pełna dokumenatcja samych szablonów jest dostępna, wraz z przykładami <a href=\"https://shopify.github.io/liquid/basics/introduction/\">pod tym adresem </a></html>");
        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        link.setForeground(Color.GRAY);
        link.setAlignmentX(0.5f);

        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://shopify.github.io/liquid/basics/introduction/"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });

        getContentPane().add(link);
        getContentPane().add(controlPanel);


        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu file = new JMenu("Plik");
        mb.add(file);
        JMenu edit = new JMenu("Edycja");
        mb.add(edit);
        JMenu help = new JMenu("Pomoc");
        mb.add(help);

        pack();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
