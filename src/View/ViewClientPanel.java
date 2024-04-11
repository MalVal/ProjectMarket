package View;

import Model.*;
import Model.Entity.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewClientPanel extends JPanel
{
    public JTable tableClient;

    public ViewClientPanel(ArrayList<Client> listClient)
    {
        super();

        tableClient = new JTable();
        tableClient.setModel(new ModelTableClient(listClient));
        tableClient.setColumnModel(new ModelColumnTableClient());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableClient);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Client :"));
        this.add(jScrollPane);
    }
}