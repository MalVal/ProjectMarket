package Model.ModelTable;

import Model.Entity.Provider;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelTableProvider extends AbstractTableModel
{
    private final ArrayList<Provider> providers;
    public ModelTableProvider(ArrayList<Provider> providers)
    {
        this.providers = providers;
    }

    @Override
    public Class<?> getColumnClass(int c)
    {
        return switch (c) {
            case 0, 1, 2 -> String.class;
            default -> Object.class;
        };
    }

    @Override
    public int getRowCount()
    {
        return providers.size();
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Provider provider = providers.get(l);
        if (c == -1) return provider;
        if (c == 0) return provider.getName();
        if (c == 1) return provider.getAddress();
        if (c == 2) return provider.getPhoneNumber();
        return null;
    }
}
