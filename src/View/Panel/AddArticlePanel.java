package View.Panel;

import Controller.ControllerActions;
import Model.Entity.Article;
import Model.Entity.ArticleType;
import Model.Entity.Provider;
import Model.ModelComboBox.CustomComboBoxModel;
import View.Employee.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddArticlePanel extends JPanel
{
    private JComboBox<ArticleType> listArticle;
    private JComboBox<Provider> listProvider;
    private JTextField textFieldQuantity;
    public CustomComboBoxModel<ArticleType> articleTypeComboBoxModel;
    public CustomComboBoxModel<Provider> providerComboBoxModel;
    public EmployeeWindow parent;

    public Article article;

    public AddArticlePanel(EmployeeWindow parent)
    {
        super();

        this.article = new Article();

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
        JButton btnAdd = new JButton("Add");
        this.add(btnAdd);

        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(listArticle.getSelectedItem() == null)
                    {
                        JOptionPane.showMessageDialog(getParent(), "You have to select a type !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    article.setType((ArticleType)listArticle.getSelectedItem());

                    if(listProvider.getSelectedItem() == null)
                    {
                        JOptionPane.showMessageDialog(getParent(), "You have to select a provider !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    article.setProvider((Provider)listProvider.getSelectedItem());

                    article.setQuantity(Integer.parseInt(textFieldQuantity.getText()));

                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_ARTICLE));
                    article = new Article();
                    textFieldQuantity.setText("");
                    listProvider.setSelectedItem(null);
                    listArticle.setSelectedItem(null);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Invalid quantity !", "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}