package View.Employee;

import Controller.ControllerActions;
import View.Panel.BtnDeleteModifyPanel;
import View.Panel.CreateEmployeePanel;
import View.ViewPanel.ViewEmployeePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Add SubPanel
        BtnDeleteModifyPanel subPanel = new BtnDeleteModifyPanel("Delete selected employee", "Modify selected employee");
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        this.add(subPanel, constraints);

        // Add CreateEmployeePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createEmployeePanel, constraints);

        subPanel.btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.DELETE_EMPLOYEE));
            }
        });

        subPanel.btnModify.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.MODIFY_EMPLOYEE));
            }
        });
    }
}