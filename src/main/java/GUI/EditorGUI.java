package GUI;

import Liquid.Context;
import Liquid.Renderer;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditorGUI extends JFrame {
    public EditorGUI() {
        Intro intro = new Intro();
        InputTable table = new InputTable();
        TextPanel input = new TextPanel("Witaj! \n\nMożesz edytować ten {{ co }} rezultaty \npojawią się {{ gdzie }}", Color.white);
        Renderer view = new Renderer(input.getText(), table.getContext());
        TextPanel output = new TextPanel(view.render(), new Color(243, 243, 243));
        JTextPane pane = input.getPane();
        JPanel editingArea = new JPanel();
        Menu menu = new Menu(input);

        output.makeReadonly();
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
                output.setText(new Renderer(pane.getText(), table.getContext()).render());
            }
        });

        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                output.clearText();
                output.setText(new Renderer(pane.getText(), table.getContext()).render());
            }
        });

        editingArea.setLayout(new GridLayout(0, 2));
        editingArea.add(input.getScroll());
        editingArea.add(output.getScroll());

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(intro.getLabel());
        getContentPane().add(editingArea);
        getContentPane().add(table.getScroll());

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
