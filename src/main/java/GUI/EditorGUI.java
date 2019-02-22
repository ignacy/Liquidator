package GUI;

import Liquid.Renderer;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class EditorGUI extends JFrame {
    public EditorGUI() {


        HashMap context = new HashMap<String, String>();
        context.put("name", "WORLD");
        context.put("what", "fun!");

        TextPanel input = new TextPanel("Hello {{name}}. I hope you have {{ what }}", Color.white);

        Renderer view = new Renderer(input.getText(), context);
        TextPanel output = new TextPanel(view.render(), new Color(232, 232, 232));
        output.makeReadonly();

        JTextPane pane = input.getPane();
        pane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                output.clearText();
                output.setText(new Renderer(pane.getText(), context).render());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setLayout(new GridLayout(0, 2));

        getContentPane().add(input.getScroll());
        getContentPane().add(output.getScroll());

        pack();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
