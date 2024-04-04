package View;

import javax.swing.*;
import java.awt.*;
public class CreateArticleTypePanel extends JPanel
{
    private JTextField textFieldName;
    private JTextField textFieldCategory;
    private JTextField textFieldPrice;

    public CreateArticleTypePanel()
    {
        super();

        textFieldName = new JTextField();
        textFieldCategory = new JTextField();
        textFieldPrice = new JTextField();

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
        this.add(new JButton("Create"));
    }
}