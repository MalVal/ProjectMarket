package Model;

import javax.swing.table.*;

public class ModelColumnTableEmployee extends DefaultTableColumnModel
{
    public ModelColumnTableEmployee()
    {
        super();
        int[] columnSize = {25, 25, 25, 25, 25};
        String[] columnNames = {"Name", "Firstname", "Birthdate", "Salary", "Registration number"};
        for (int i=0; i<columnSize.length; i++)
        {
            TableColumn c = new TableColumn(i, columnSize[i]);
            c.setHeaderValue(columnNames[i]);
            addColumn(c);
        }
    }
}