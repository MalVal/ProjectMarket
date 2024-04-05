package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewArticleTypePanel extends JPanel
{
    public JTable tableArticleType;

    public ViewArticleTypePanel(ArrayList<ArticleType> listArticleType)
    {
        super();

        tableArticleType = new JTable();
        tableArticleType.setModel(new ModelTableArticleType(listArticleType));
        tableArticleType.setColumnModel(new ModelColumnTableArticleType());

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Article type :"));
        this.add(tableArticleType);
    }
}