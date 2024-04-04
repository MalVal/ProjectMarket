package View;

import Model.ArticleType;
import Model.Provider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddArticlePanel extends JPanel
{
    private JList<ArticleType> listArticle;
    private JList<Provider> listProvider;
    private JTextField textFieldQuantity;

    public AddArticlePanel(ArrayList<ArticleType> articleTypeData, ArrayList<Provider> providerData)
    {
        super();

        listArticle = new JList<ArticleType>();
        listArticle.setListData(articleTypeData.toArray(new ArticleType[0]));
        listProvider = new JList<Provider>();
        listProvider.setListData(providerData.toArray(new Provider[0]));
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