package View.Employee;

import View.Panel.AddArticlePanel;
import View.ViewPanel.ViewArticlePanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeArticlePanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewArticlePanel viewArticlePanel;
    public AddArticlePanel addArticlePanel;

    public EmployeeArticlePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewArticlePanel = new ViewArticlePanel();
        this.addArticlePanel = new AddArticlePanel(this.parent);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add ViewArticlePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.5; // 50% de l'espace vertical
        this.add(viewArticlePanel, constraints);

        // Add JButton
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        JButton btnDelete = new JButton("Delete selected article");
        this.add(btnDelete, constraints);

        // Add addArticlePanel
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0; // Utilise tout l'espace disponible en largeur
        constraints.weighty = 0.4; // 40% de l'espace vertical
        this.add(addArticlePanel, constraints);
    }
}