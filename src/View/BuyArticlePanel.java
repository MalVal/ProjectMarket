package View;

import Model.Article;

import javax.swing.*;
import java.awt.*;
public class BuyArticlePanel extends JPanel
{
    public BuyArticlePanel()
    {
        super();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(2, 2));
        subPanel.add(new JLabel("Article :"));
        subPanel.add(new JList<Article>());
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(new JTextField());

        this.add(new JLabel("Buy an article :"));
        this.add(subPanel);
        this.add(new JButton("Buy"));
    }
}