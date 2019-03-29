package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

class Menu {
    private JMenuBar menuBar;
    private TextPanel input;

    Menu(TextPanel input) {
        this.input = input;
        this.menuBar = new JMenuBar();

        JMenu file = new JMenu("Plik");
        file.setMnemonic(KeyEvent.VK_P);
        menuBar.add(file);

        JMenuItem open = new JMenuItem("Otwórz");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        file.add(open);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file == null) {
                        return;
                    }

                    try {
                        BufferedReader in = new BufferedReader(new FileReader(file));
                        StringBuffer stringBuffer = new StringBuffer();
                        String line = null;
                        while ((line = in.readLine()) != null) {
                            stringBuffer.append(line).append("\n");
                        }
                        input.setText(stringBuffer.toString());
                    } catch (IOException ex) {
                        System.out.println("Problem saving to a file");
                    }
                }
            }
        });

        JMenuItem save = new JMenuItem("Zapisz");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        file.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file == null) {
                        return;
                    }

                    if (!((File) file).getName().toLowerCase().endsWith(".liquid")) {
                        file = new File(file.getParentFile(), file.getName() + ".liquid");
                    }

                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(input.getText());
                        writer.close();
                    } catch (IOException ex) {
                        System.out.println("Problem saving to a file");
                    }
                }
            }
        });


        JMenuItem quit = new JMenuItem("Zamknij");
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        file.add(quit);

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    JMenuBar getMenuBar() {
        return menuBar;
    }
}
