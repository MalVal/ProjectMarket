package Model;

import Model.Entity.Purchase;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelTablePurchase extends AbstractTableModel
{
    private ArrayList<Purchase> purchases;
    public ModelTablePurchase(ArrayList<Purchase> purchases)
    {
        this.purchases = purchases;
    }

    @Override
    public Class getColumnClass(int c)
    {
        if (c == 0) return String.class;
        if (c == 1) return String.class;
        if (c == 2) return Double.class;
        return null;
    }

    @Override
    public int getRowCount()
    {
        return purchases.size();
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Purchase purchase = purchases.get(l);
        if (c == 0) return purchase.getBuyer().toString();
        if (c == 1) return purchase.getListArticle().toString();
        if (c == 2) return purchase.getTotal();
        return null;
    }
}
