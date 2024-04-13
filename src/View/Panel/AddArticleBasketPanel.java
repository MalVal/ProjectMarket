package View.Panel;

import Model.Entity.Article;
import Model.ModelComboBox.CustomComboBoxModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddArticleBasketPanel extends JPanel
{
    public CustomComboBoxModel<Article> articleComboBoxModel;
    private JComboBox<Article> listArticle;
    private JTextField textFieldQuantity;

    public AddArticleBasketPanel()
    {
        super();

        this.articleComboBoxModel = new CustomComboBoxModel<>(new ArrayList<>());
        listArticle = new JComboBox<Article>(articleComboBoxModel);
        textFieldQuantity = new JTextField();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(2, 2));
        subPanel.add(new JLabel("Article :"));
        subPanel.add(listArticle);
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(textFieldQuantity);

        this.add(new JLabel("Add an article :"));
        this.add(subPanel);
        this.add(new JButton("Add to basket"));
    }
}