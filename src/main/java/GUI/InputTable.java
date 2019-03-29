package GUI;

import javax.swing.*;
import java.awt.*;

public class InputTable extends JFrame {
    JScrollPane scroll;

    public InputTable() {
        String[][] content = {
                {"hello", "Hello there!"},
                {"list", "[1,2,3,4,5]"}
        };
        String[] columns = { "Name", "Value" };
        JTable table = new JTable(content, columns);
        table.setPreferredScrollableViewportSize(new Dimension(400, 100));

        scroll = new JScrollPane(table);
    }

    JScrollPane getScroll() {
        return scroll;
    }
}
