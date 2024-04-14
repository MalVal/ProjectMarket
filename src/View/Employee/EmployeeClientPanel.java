package View.Employee;

import View.Panel.CreateClientPanel;
import View.ViewPanel.ViewClientPanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeClientPanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewClientPanel viewClientPanel;
    public CreateClientPanel createClientPanel;

    public EmployeeClientPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewClientPanel = new ViewClientPanel();
        this.createClientPanel = new CreateClientPanel(this.parent);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add ViewClientPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.6; // 50% de l'espace vertical
        this.add(viewClientPanel, constraints);

        // Add JButton
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        JButton btnDelete = new JButton("Delete selected Client");
        this.add(btnDelete, constraints);

        // Add CreateClientPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createClientPanel, constraints);
    }
}