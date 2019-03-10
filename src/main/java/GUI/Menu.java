package GUI;

import javax.swing.*;

class Menu {
    private JMenuBar menuBar;

    Menu() {
        this.menuBar = new JMenuBar();
        JMenu file = new JMenu("Plik");
        menuBar.add(file);
        JMenu edit = new JMenu("Edycja");
        menuBar.add(edit);
        JMenu help = new JMenu("Pomoc");
        menuBar.add(help);
    }

    JMenuBar getMenuBar() {
        return menuBar;
    }
}
