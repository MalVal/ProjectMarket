package View;

import Controler.CreateArticleButtonListener;
import Model.ArticleType;
import Model.MainData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateArticleTypePanel extends JPanel
{
    public JTextField textFieldName;
    public JTextField textFieldCategory;
    public JTextField textFieldPrice;
    public JLabel labelError;
    private JButton btnCreate;
    public ArrayList<ArticleType> articleTypeList;
    public EmployeeWindow parent;

    public CreateArticleTypePanel(EmployeeWindow parent, MainData data)
    {
        super();

        this.parent = parent;
        this.articleTypeList = data.getListArticleType();

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
        btnCreate.addActionListener(new CreateArticleButtonListener(this));
    }
}