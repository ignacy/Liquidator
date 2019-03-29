package GUI;

import Liquid.Context;
import Liquid.LiquidException;
import Liquid.Renderer;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Głowny kontroler aplikacji:
 * - łączy wszystkie elementy interfejsu użytkownika
 * - obsługuje zdażenia
 * - obsługuje błędy
 */
public class EditorGUI extends JFrame implements TableModelListener, KeyListener {
    InputTable table;
    TextPanel input, output;
    Renderer view;
    JTextPane pane;
    JPanel editingArea;
    ErrorDetails errorLabel;

    private String initialTemplateContent = "Witaj! \n " +
            "Możesz edytować ten {{ co }} rezultaty \n " +
            "pojawią się {{ gdzie }}. \n\n\n" +
            "{% for i in (1..5) %}\n" +
            "  {% for i in (1..i) %}" +
            "{{i}} " + "{% endfor %}\n" +
            "{% endfor %}\n" +
            "{{ hello | upcase }}\n" +
            "{{ \"Witaj \" | append: \" świecie!\" }}"
            ;

    public EditorGUI() {
        // Tabela do ustawiania par klucz - wartość do wypełnienia szablonu
        table = new InputTable();
        table.getModel().addTableModelListener(this);

        // Pole z wartością szablonu
        input = new TextPanel(initialTemplateContent, Color.WHITE);
        pane = input.getPane();
        pane.addKeyListener(this);

        // Widok łączący dane i szablon
        view = new Renderer(input.getText(), table.getContext());

        // Panel prezentujący postać wynikową
        output = new TextPanel("", new Color(243, 243, 243));
        output.makeReadonly();

        // Panel pokazujący detale błedu
        errorLabel = new ErrorDetails();

        try {
            output.setText(view.render());
        } catch (LiquidException | BadLocationException ex) {
            errorLabel.getLabel().setText(ex.getMessage());
            output.markAsError();
        }

        editingArea = new JPanel();
        editingArea.setLayout(new GridLayout(0, 2));
        editingArea.add(input.getScroll());
        editingArea.add(output.getScroll());

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new Intro().getLabel());
        getContentPane().add(editingArea);
        getContentPane().add(errorLabel.getLabel());
        getContentPane().add(table.getScroll());

        setJMenuBar(new Menu(input).getMenuBar());

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tableChanged(TableModelEvent e) {
        try {
            errorLabel.getLabel().setText("");
            output.clearText();
            output.setText(new Renderer(pane.getText(), table.getContext()).render());
        } catch (LiquidException | BadLocationException ex) {
            errorLabel.getLabel().setText(ex.getMessage());
            output.markAsError();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            errorLabel.getLabel().setText("");
            output.clearText();
            output.setText(new Renderer(pane.getText(), table.getContext()).render());
        } catch (LiquidException | BadLocationException ex) {
            output.markAsError();
            errorLabel.getLabel().setText(ex.getMessage());
        }
    }
}
