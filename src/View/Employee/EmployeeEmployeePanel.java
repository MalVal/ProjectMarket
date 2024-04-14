package View.Employee;

import View.Panel.CreateEmployeePanel;
import View.ViewPanel.ViewEmployeePanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeEmployeePanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewEmployeePanel viewEmployeePanel;
    public CreateEmployeePanel createEmployeePanel;

    public EmployeeEmployeePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewEmployeePanel = new ViewEmployeePanel();
        this.createEmployeePanel = new CreateEmployeePanel(this.parent);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add ViewEmployeePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.5; // 50% de l'espace vertical
        this.add(viewEmployeePanel, constraints);

        // Add JButton
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        JButton btnDelete = new JButton("Delete selected Employee");
        this.add(btnDelete, constraints);

        // Add CreateEmployeePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createEmployeePanel, constraints);
    }
}