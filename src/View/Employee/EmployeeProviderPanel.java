package View.Employee;

import View.Panel.CreateProviderPanel;
import View.ViewPanel.ViewProviderPanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeProviderPanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewProviderPanel viewProviderPanel;
    public CreateProviderPanel createProviderPanel;

    public EmployeeProviderPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewProviderPanel = new ViewProviderPanel();
        this.createProviderPanel = new CreateProviderPanel(this.parent);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add ViewProviderPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.5; // 50% de l'espace vertical
        this.add(viewProviderPanel, constraints);

        // Add JButton
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        JButton btnDelete = new JButton("Delete selected provider");
        this.add(btnDelete, constraints);

        // Add CreateProviderPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createProviderPanel, constraints);
    }
}