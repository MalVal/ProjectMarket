package View.Panel;

import Controller.ControllerActions;
import Model.Entity.ArticleType;
import View.Employee.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateArticleTypePanel extends JPanel
{
    public JTextField textFieldName;
    public JTextField textFieldCategory;
    public JTextField textFieldPrice;
    public JLabel labelError;
    private JButton btnCreate;

    public EmployeeWindow parent;
    public ArticleType articleType;

    public CreateArticleTypePanel(EmployeeWindow parent)
    {
        super();

        articleType = new ArticleType();

        this.parent = parent;

        textFieldName = new JTextField();
        textFieldCategory = new JTextField();
        textFieldPrice = new JTextField();
        labelError = new JLabel();
        btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(4,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(textFieldName);
        subPanel.add(new JLabel("Category :"));
        subPanel.add(textFieldCategory);
        subPanel.add(new JLabel("Price :"));
        subPanel.add(textFieldPrice);

        this.add(new JLabel("Create a new article type :"));
        this.add(subPanel);
        this.add(labelError);
        this.add(btnCreate);

        btnCreate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    articleType.setName(textFieldName.getText());
                    articleType.setCategory(textFieldCategory.getText());
                    articleType.setPrice(Double.parseDouble(textFieldPrice.getText()));
                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_ARTICLE_TYPE));
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Mauvais format de prix !", "Erreur !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}