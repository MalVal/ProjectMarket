package Model.ModelTable;

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
        if (c == 2) return String.class;
        if (c == 3) return LocalDate.class;
        if (c == 4) return Double.class;
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
        return 5;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Client client = clients.get(l);
        if(c == -1) return client;
        if (c == 0) return client.getRegistrationNumber();
        if (c == 1) return client.getName();
        if (c == 2) return client.getFirstname();
        if (c == 3) return client.getBirthdate();
        if (c == 4) return client.getDiscount();
        return null;
    }
}
