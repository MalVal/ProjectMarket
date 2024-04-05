package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewProviderPanel extends JPanel
{
    public JTable tableProvider;

    public ViewProviderPanel(ArrayList<Provider> listProvider)
    {
        super();

        tableProvider = new JTable();
        tableProvider.setModel(new ModelTableProvider(listProvider));
        tableProvider.setColumnModel(new ModelColumnTableProvider());

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Provider :"));
        this.add(tableProvider);
    }
}