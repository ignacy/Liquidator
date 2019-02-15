package GUI;

import Liquid.Renderer;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class EditorGUI extends JFrame {
    public EditorGUI() {

        JTextArea inputText = new JTextArea("Hello {{ name }} ! ");
        inputText.setEditable(true);
        inputText.setFont(new Font("monospaced", Font.PLAIN, 16));
        //inputText.setFont(inputText.getFont().deriveFont(15f));
        JScrollPane scroll = new JScrollPane(inputText);


        HashMap context = new HashMap<String, String>();
        context.put("name", "WORLD");
        Renderer view = new Renderer(inputText.getText(), context);


        Color color = new Color(241, 255, 244);
        JTextArea outputText = new JTextArea(view.render());
        outputText.setEditable(false);
        outputText.setFont(inputText.getFont());
        outputText.setBackground(color);
        JScrollPane scrollOut = new JScrollPane(outputText);

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setLayout(new GridLayout(0, 2));

        getContentPane().add(scroll);
        getContentPane().add(scrollOut);

        pack();
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
