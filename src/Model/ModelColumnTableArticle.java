package Model;

import javax.swing.table.*;

public class ModelColumnTableArticle extends DefaultTableColumnModel
{
    public ModelColumnTableArticle()
    {
        super();
        int[] columnSize = {45, 45, 10};
        String[] columnNames = {"Type", "Provider", "Quantity"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}