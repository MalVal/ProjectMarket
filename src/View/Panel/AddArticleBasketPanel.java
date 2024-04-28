package View.Panel;

import Controller.ControllerActions;
import Model.Entity.Article;
import Model.ModelComboBox.CustomComboBoxModel;
import View.Client.ClientWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddArticleBasketPanel extends JPanel
{
    public CustomComboBoxModel<Article> articleComboBoxModel;
    private final JComboBox<Article> listArticle;
    private final JTextField textFieldQuantity;

    public Article article;

    public ClientWindow parent;

    public AddArticleBasketPanel(ClientWindow parent)
    {
        super();

        this.parent = parent;

        this.article = new Article();

        this.articleComboBoxModel = new CustomComboBoxModel<>(new ArrayList<>());
        listArticle = new JComboBox<>(articleComboBoxModel);
        textFieldQuantity = new JTextField();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(2, 2));
        subPanel.add(new JLabel("Article :"));
        subPanel.add(listArticle);
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(textFieldQuantity);

        this.add(new JLabel("Add an article :"));
        this.add(subPanel);
        JButton btnAdd = new JButton("Add to basket");
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
                        JOptionPane.showMessageDialog(getParent(), "You have to select an article !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    article = ((Article)listArticle.getSelectedItem()).clone();

                    int quantity = Integer.parseInt(textFieldQuantity.getText());
                    if(quantity <= 0)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid quantity (can't be negative or null) !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    article.setQuantity(quantity);

                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_TO_BASKET));
                    article = new Article();
                    textFieldQuantity.setText("");
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