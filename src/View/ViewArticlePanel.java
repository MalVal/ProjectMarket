package View;

import Model.Entity.Article;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewArticlePanel extends JPanel
{
    public JTable tableArticle;

    public ViewArticlePanel(ArrayList<Article> listArticle)
    {
        super();

        tableArticle = new JTable();
        tableArticle.setModel(new ModelTableArticle(listArticle));
        tableArticle.setColumnModel(new ModelColumnTableArticle());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableArticle);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Article :"));
        this.add(jScrollPane);
    }
}