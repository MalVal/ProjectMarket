package Model.ModelTable;

import Model.Entity.Client;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelTableClient extends AbstractTableModel
{
    private final ArrayList<Client> clients;
    public ModelTableClient(ArrayList<Client> clients)
    {
        this.clients = clients;
    }

    @Override
    public Class getColumnClass(int c)
    {
        return switch (c) {
            case 0, 1, 2 -> String.class;
            case 3 -> LocalDate.class;
            case 4 -> Double.class;
            default -> Object.class;
        };
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
        return switch (c) {
            case -1 -> client;
            case 0 -> client.getRegistrationNumber();
            case 1 -> client.getName();
            case 2 -> client.getFirstname();
            case 3 -> client.getBirthdate();
            case 4 -> client.getDiscount();
            default -> null;
        };
    }
}
