package Model.ModelColumnTable;

import javax.swing.table.*;

public class ModelColumnTableClient extends DefaultTableColumnModel
{
    public ModelColumnTableClient()
    {
        super();
        int[] columnSize = {20, 20, 20, 20, 20};
        String[] columnNames = {"Registration number" ,"Name", "Firstname", "Birthdate", "Discount"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}