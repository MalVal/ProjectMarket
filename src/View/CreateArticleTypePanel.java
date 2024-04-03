package View;

import javax.swing.*;
import java.awt.*;
public class CreateArticleTypePanel extends JPanel
{
    public CreateArticleTypePanel()
    {
        super();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(new JTextField());
        subPanel.add(new JLabel("Category :"));
        subPanel.add(new JTextField());
        subPanel.add(new JLabel("Price :"));
        subPanel.add(new JTextField());

        this.add(new JLabel("Create a new article type :"));
        this.add(subPanel);
        this.add(new JButton("Create"));
    }
}