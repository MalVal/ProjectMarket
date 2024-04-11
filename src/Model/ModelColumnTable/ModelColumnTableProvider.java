package Model.ModelColumnTable;

import javax.swing.table.*;

public class ModelColumnTableProvider extends DefaultTableColumnModel
{
    public ModelColumnTableProvider()
    {
        super();
        int[] columnSize = {30, 60, 10};
        String[] columnNames = {"Name", "Address", "Phone number"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}