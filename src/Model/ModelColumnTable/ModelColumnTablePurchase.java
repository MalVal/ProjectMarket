package Model.ModelColumnTable;

import javax.swing.table.*;

public class ModelColumnTablePurchase extends DefaultTableColumnModel
{
    public ModelColumnTablePurchase()
    {
        super();
        int[] columnSize = {30, 60, 10};
        String[] columnNames = {"Client", "Articles", "Total"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}