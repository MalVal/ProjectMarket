package View;

import Model.Entity.Article;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewArticlePanel extends JPanel
{
    public JTable tableArticle;

    public ViewArticlePanel()
    {
        super();

        tableArticle = new JTable();
        tableArticle.setModel(new ModelTableArticle(new ArrayList<>()));
        tableArticle.setColumnModel(new ModelColumnTableArticle());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableArticle);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Article :"));
        this.add(jScrollPane);
    }
}