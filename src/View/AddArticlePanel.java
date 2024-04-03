package View;

import Model.ArticleType;
import Model.Provider;

import javax.swing.*;
import java.awt.*;
public class AddArticlePanel extends JPanel
{
    public AddArticlePanel()
    {
        super();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Type :"));
        subPanel.add(new JList<ArticleType>());
        subPanel.add(new JLabel("Provider :"));
        subPanel.add(new JList<Provider>());
        subPanel.add(new JLabel("Quantity :"));
        subPanel.add(new JTextField());

        this.add(new JLabel("Add a new article :"));
        this.add(subPanel);
        this.add(new JButton("Add"));
    }
}