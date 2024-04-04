package View;

import Model.MainData;
import Model.ModelColumnTablePurchase;
import Model.Purchase;
import Model.ModelTablePurchase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PurchasePanel extends JPanel
{
    public JTable tablePurchase;

    public PurchasePanel(MainData data)
    {
        super();

        tablePurchase = new JTable();
        tablePurchase.setModel(new ModelTablePurchase(data.getListPurchase()));
        tablePurchase.setColumnModel(new ModelColumnTablePurchase());

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Purchase :"));
        this.add(tablePurchase);
    }
}