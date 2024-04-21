package View.ViewPanel;

import Model.ModelColumnTable.ModelColumnTablePurchase;
import Model.ModelTable.ModelTablePurchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
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

        this.setLayout(new GridLayout(3,1));

        this.add(new JLabel("Purchase :"));
        this.add(jScrollPane);
        JButton btnPrint = new JButton("Print");
        this.add(btnPrint);

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    boolean complete = tablePurchase.print();
                    if (complete)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Printed", "Success !", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(getParent(), "Cancel", "Error !", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (PrinterException pe)
                {
                    JOptionPane.showMessageDialog(getParent(), pe.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}