package View;

import Model.ModelColumnTablePurchase;
import Model.ModelTablePurchase;
import Model.Entity.Purchase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewPurchasePanel extends JPanel
{
    public JTable tablePurchase;

    public ViewPurchasePanel()
    {
        super();

        tablePurchase = new JTable();
        tablePurchase.setModel(new ModelTablePurchase(new ArrayList<>()));
        tablePurchase.setColumnModel(new ModelColumnTablePurchase());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tablePurchase);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Purchase :"));
        this.add(jScrollPane);
    }
}