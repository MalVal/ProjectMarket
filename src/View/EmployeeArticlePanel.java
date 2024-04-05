package View;

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
        this.viewArticlePanel = new ViewArticlePanel(this.parent.main.data.getListArticle());
        this.addArticlePanel = new AddArticlePanel(this.parent);

        this.setLayout(new GridLayout(2,1));

        this.add(viewArticlePanel);
        this.add(addArticlePanel);
    }
}