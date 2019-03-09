package GUI;

import Liquid.Context;
import Liquid.Renderer;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        TextPanel output = new TextPanel(view.render(), new Color(232, 232, 232));
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
        controlPanel.add(input.getScroll());
        controlPanel.add(output.getScroll());

        setLayout(new GridLayout(2,1));

        JLabel label1 = new JLabel("Image and Text", JLabel.CENTER);

        getContentPane().add(label1);
        getContentPane().add(controlPanel);

        pack();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
