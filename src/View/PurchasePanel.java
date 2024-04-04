package View;

import Model.Purchase;
import Model.ModelTablePurchase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PurchasePanel extends JPanel
{
    private JTable tablePurchase;

    public PurchasePanel(ArrayList<Purchase> purchases)
    {
        super();

        tablePurchase = new JTable();
        tablePurchase.setModel(new ModelTablePurchase(purchases));

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Purchase :"));
        this.add(tablePurchase);
    }
}