package GUI;

import Liquid.Context;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class InputTable extends JFrame {
    JScrollPane scroll;
    TableModel dtm;

    public InputTable() {
        String[] columns = { "Name", "Value" };
        JTable table = new JTable();
        dtm = new TableModel(10, 2);
        dtm.setDataVector(dtm.getContext().asTableContents(), columns);
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});
        dtm.addRow(new Object[]{"", ""});

        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.setRowHeight(table.getRowHeight()+ 10);
        table.putClientProperty("terminateEditOnFocusLost", true);
        table.setCellSelectionEnabled(true);
        table.setModel(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(400, 50));
        scroll = new JScrollPane(table);
    }

    JScrollPane getScroll() {
        return scroll;
    }

    Context getContext() {
        return dtm.getContext();
    }

    TableModel getModel() {
        return dtm;
    }


}
