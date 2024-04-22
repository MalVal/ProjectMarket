package View.Employee;

import Controller.ControllerActions;
import View.Panel.BtnDeleteModifyPanel;
import View.Panel.CreateArticleTypePanel;
import View.ViewPanel.ViewArticleTypePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeArticleTypePanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewArticleTypePanel viewArticleTypePanel;
    public CreateArticleTypePanel createArticleTypePanel;

    public EmployeeArticleTypePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewArticleTypePanel = new ViewArticleTypePanel();
        this.createArticleTypePanel = new CreateArticleTypePanel(this.parent);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add ViewArticleTypePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.5; // 50% de l'espace vertical
        this.add(viewArticleTypePanel, constraints);

        // Add SubPanel
        BtnDeleteModifyPanel subPanel = new BtnDeleteModifyPanel("Delete selected article type", "Modify selected article type");
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        this.add(subPanel, constraints);

        // Add CreateArticleTypePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(createArticleTypePanel, constraints);

        subPanel.btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.DELETE_ARTICLE_TYPE));
            }
        });

        subPanel.btnModify.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.MODIFY_ARTICLE_TYPE));
            }
        });
    }
}