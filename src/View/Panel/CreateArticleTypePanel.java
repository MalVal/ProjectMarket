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
        JButton btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(textFieldName);
        subPanel.add(new JLabel("Category :"));
        subPanel.add(textFieldCategory);
        subPanel.add(new JLabel("Price :"));
        subPanel.add(textFieldPrice);

        this.add(new JLabel("Create a new article type :"));
        this.add(subPanel);
        this.add(btnCreate);

        btnCreate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(textFieldName.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid name !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    articleType.setName(textFieldName.getText());

                    if(textFieldCategory.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid category !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    articleType.setCategory(textFieldCategory.getText());

                    double price = Double.parseDouble(textFieldPrice.getText());
                    if(price <= 0)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid price (can't be negative or null) !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    articleType.setPrice(price);

                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_ARTICLE_TYPE));
                    articleType = new ArticleType();
                    textFieldName.setText("");
                    textFieldCategory.setText("");
                    textFieldPrice.setText("");
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Invalid price !", "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}