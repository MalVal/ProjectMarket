package View;

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
        this.viewArticleTypePanel = new ViewArticleTypePanel(this.parent.main.data.getListArticleType());
        this.createArticleTypePanel = new CreateArticleTypePanel(this.parent);

        this.setLayout(new GridLayout(2,1));

        this.add(viewArticleTypePanel);
        this.add(createArticleTypePanel);
    }
}