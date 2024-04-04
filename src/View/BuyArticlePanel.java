package View;

import Model.Article;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuyArticlePanel extends JPanel
{
    private JList<Article> listArticle;
    private JTextField textFieldQuantity;

    public BuyArticlePanel(ArrayList<Article> articleData)
    {
        super();

        listArticle = new JList<Article>();
        listArticle.setListData(articleData.toArray(new Article[0]));
        textFieldQuantity = new JTextField();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(2, 2));
        subPanel.add(new JLabel("Article :"));
        subPanel.add(listArticle);
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(textFieldQuantity);

        this.add(new JLabel("Buy an article :"));
        this.add(subPanel);
        this.add(new JButton("Buy"));
    }
}