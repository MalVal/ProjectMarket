package Model.ModelColumnTable;

import javax.swing.table.*;

public class ModelColumnTableArticleType extends DefaultTableColumnModel
{
    public ModelColumnTableArticleType()
    {
        super();
        int[] columnSize = {45, 45, 10};
        String[] columnNames = {"Name", "Category", "Price"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}