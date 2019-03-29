package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class InputTable extends JFrame {
    JScrollPane scroll;
    DefaultTableModel dtm;

    public InputTable(String[][] initialData) {
        String[] columns = { "Name", "Value" };
        JTable table = new JTable();
        dtm = new DefaultTableModel(10, 2);

        dtm.setDataVector(initialData, columns);
        table.setModel(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(400, 50));

        scroll = new JScrollPane(table);
    }

    JScrollPane getScroll() {
        return scroll;
    }
}
