package Model;

import Model.Entity.Client;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelTableClient extends AbstractTableModel
{
    private ArrayList<Client> clients;
    public ModelTableClient(ArrayList<Client> clients)
    {
        this.clients = clients;
    }

    @Override
    public Class getColumnClass(int c)
    {
        if (c == 0) return String.class;
        if (c == 1) return String.class;
        if (c == 2) return LocalDate.class;
        if (c == 3) return Double.class;
        return null;
    }

    @Override
    public int getRowCount()
    {
        return clients.size();
    }

    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Client client = clients.get(l);
        if (c == 0) return client.getName();
        if (c == 1) return client.getFirstname();
        if (c == 2) return client.getBirthdate();
        if (c == 3) return client.getDiscount();
        return null;
    }
}
