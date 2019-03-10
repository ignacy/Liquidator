package GUI;

import Liquid.Context;
import Liquid.Renderer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Główna klasa zajmująca się renderowaniem i obsługą interfejsu użytkownika
 */
public class EditorGUI extends JFrame {
    public EditorGUI(Context context) {
       // Panel w którym edytowany jest tekst szablonu, wypełniony
        // przykładowym tekstem/zachętą
        TextPanel input = new TextPanel("Witaj! \n\nMożesz edytować ten {{ co }} rezultaty \npojawią się {{ gdzie }}", Color.white);

        // Renderujemy zachęte
        Renderer view = new Renderer(input.getText(), context);

        // Panel gdzie widoczne będą rezultaty renderowania szablonów Liquid
        TextPanel output = new TextPanel(view.render(), new Color(243, 243, 243));
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

        JPanel editingArea = new JPanel();
        editingArea.setLayout(new GridLayout(0, 2));
        editingArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        editingArea.add(output.getScroll());
        editingArea.add(input.getScroll());

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Intro intro = new Intro();
        getContentPane().add(intro.getLabel());
        getContentPane().add(editingArea);

        Menu menu = new Menu();
        setJMenuBar(menu.getMenuBar());

        pack();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1600, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
