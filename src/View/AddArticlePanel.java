package View;

import Model.ArticleType;
import Model.Provider;
import Model.CustomComboBoxModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddArticlePanel extends JPanel
{
    private JComboBox<ArticleType> listArticle;
    private JComboBox<Provider> listProvider;
    private JTextField textFieldQuantity;

    public AddArticlePanel(ArrayList<ArticleType> articleTypeData, ArrayList<Provider> providerData)
    {
        super();

        CustomComboBoxModel<ArticleType> articleTypeComboBoxModel = new CustomComboBoxModel<>(articleTypeData);
        listArticle = new JComboBox<ArticleType>(articleTypeComboBoxModel);
        CustomComboBoxModel<Provider> providerComboBoxModel = new CustomComboBoxModel<>(providerData);
        listProvider = new JComboBox<Provider>(providerComboBoxModel);
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