package View;

import Model.Article;
import Model.CustomComboBoxModel;
import Model.MainData;

import javax.swing.*;
import java.awt.*;

public class BuyArticlePanel extends JPanel
{
    private JComboBox<Article> listArticle;
    private JTextField textFieldQuantity;

    public BuyArticlePanel(MainData data)
    {
        super();

        CustomComboBoxModel<Article> articleComboBoxModel = new CustomComboBoxModel<>(data.getListArticle());
        listArticle = new JComboBox<Article>(articleComboBoxModel);
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