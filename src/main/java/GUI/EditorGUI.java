package GUI;

import Liquid.Renderer;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.HashMap;

public class EditorGUI extends JFrame {
    public EditorGUI() {

        TextPanel input = new TextPanel("Hello {{name}}. I hope you have {{ name }}", Color.white);
        HashMap context = new HashMap<String, String>();
        context.put("name", "WORLD");
        Renderer view = new Renderer(input.getText(), context);

        TextPanel output = new TextPanel(view.render(), new Color(232, 232, 232));
        output.makeReadonly();

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
