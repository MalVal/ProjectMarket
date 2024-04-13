package View.Employee;

import View.Panel.CreateArticleTypePanel;
import View.ViewPanel.ViewArticleTypePanel;

import javax.swing.*;
import java.awt.*;

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

        this.setLayout(new GridLayout(3,1));

        this.add(viewArticleTypePanel);
        JButton btnDelete = new JButton("Delete selected article type");
        this.add(btnDelete);
        this.add(createArticleTypePanel);
    }
}