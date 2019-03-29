package GUI;

import Liquid.Context;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
    Context context;

    public TableModel(int rows, int columns) {
        super(rows, columns);
        context = new Context();
        context.put("co", "tekst");
        context.put("gdzie", "po prawej stronie");
    }

    /*
     * Nadpisuje zmiane wartości w tabeli, odświerzając wartości w
     * kontekście który później jest wykorzystywany do renderowania szablonu.
     */
    @Override
    public void setValueAt(Object newValue, int row, int column)
    {
        Object oldValue = getValueAt(row, column);
        super.setValueAt(newValue, row, column);

        context = new Context();
        for (int i = 0; i < this.getRowCount(); i++) {
            context.put(this.getValueAt(i, 0).toString(), this.getValueAt(i, 1).toString());
        }
    }

    public Context getContext() {
        return context;
    }
}
