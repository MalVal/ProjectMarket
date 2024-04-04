package View;

import Model.ArticleType;
import Model.Provider;

import javax.swing.*;
import java.awt.*;
public class AddArticlePanel extends JPanel
{
    private JList<ArticleType> listArticle;
    private JList<Provider> listProvider;
    private JTextField textFieldQuantity;

    public AddArticlePanel()
    {
        super();

        listArticle = new JList<ArticleType>();
        listProvider = new JList<Provider>();
        textFieldQuantity = new JTextField();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Type :"));
        subPanel.add(listArticle);
        subPanel.add(new JLabel("Provider :"));
        subPanel.add(listProvider);
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(textFieldQuantity);

        this.add(new JLabel("Add a new article :"));
        this.add(subPanel);
        this.add(new JButton("Add"));
    }
}