package GUI;

import javax.swing.*;
import java.awt.*;

public class EditorGUI extends JFrame {
    public EditorGUI() {

        JTextArea inputText = new JTextArea("This is some {{ name }} template ");
        inputText.setEditable(true);
        JScrollPane scroll = new JScrollPane(inputText);

        Color color = new Color(111, 134, 255);
        JTextArea outputText = new JTextArea("This is some {{ name }} template ");
        outputText.setEditable(false);
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
