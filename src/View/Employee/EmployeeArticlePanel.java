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

        this.setLayout(new GridLayout(3,1));

        this.add(viewArticlePanel);
        JButton btnDelete = new JButton("Delete selected article");
        this.add(btnDelete);
        this.add(addArticlePanel);
    }
}