package View.ViewPanel;

import Model.ModelColumnTable.ModelColumnTableProvider;
import Model.ModelTable.ModelTableProvider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewProviderPanel extends JPanel
{
    public JTable tableProvider;

    public ViewProviderPanel()
    {
        super();

        tableProvider = new JTable();
        tableProvider.setModel(new ModelTableProvider(new ArrayList<>()));
        tableProvider.setColumnModel(new ModelColumnTableProvider());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableProvider);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Provider :"));
        this.add(jScrollPane);
    }
}