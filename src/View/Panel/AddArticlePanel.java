package View.Panel;

import Model.Entity.ArticleType;
import Model.Entity.Provider;
import Model.ModelComboBox.CustomComboBoxModel;
import View.Employee.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddArticlePanel extends JPanel
{
    private JComboBox<ArticleType> listArticle;
    private JComboBox<Provider> listProvider;
    private JTextField textFieldQuantity;
    public CustomComboBoxModel<ArticleType> articleTypeComboBoxModel;
    public CustomComboBoxModel<Provider> providerComboBoxModel;
    public EmployeeWindow parent;

    public AddArticlePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;

        articleTypeComboBoxModel = new CustomComboBoxModel<>(new ArrayList<>());
        listArticle = new JComboBox<ArticleType>(articleTypeComboBoxModel);
        providerComboBoxModel = new CustomComboBoxModel<>(new ArrayList<>());
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