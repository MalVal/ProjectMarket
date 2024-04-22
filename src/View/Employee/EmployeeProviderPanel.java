package View.Employee;

import Controller.ControllerActions;
import View.Panel.BtnDeleteModifyPanel;
import View.Panel.CreateProviderPanel;
import View.ViewPanel.ViewProviderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Add SubPanel
        BtnDeleteModifyPanel subPanel = new BtnDeleteModifyPanel("Delete selected provider", "Modify selected provider");
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        this.add(subPanel, constraints);

        // Add CreateProviderPanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createProviderPanel, constraints);

        subPanel.btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.DELETE_PROVIDER));
            }
        });

        subPanel.btnModify.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.MODIFY_PROVIDER));
            }
        });
    }
}