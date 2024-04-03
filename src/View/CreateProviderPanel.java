package View;

import javax.swing.*;
import java.awt.*;
public class CreateProviderPanel extends JPanel
{
    public CreateProviderPanel()
    {
        super();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(new JTextField());
        subPanel.add(new JLabel("Adress :"));
        subPanel.add(new JTextField());
        subPanel.add(new JLabel("Phone number :"));
        subPanel.add(new JTextField());

        this.add(new JLabel("Create a new provider :"));
        this.add(subPanel);
        this.add(new JButton("Create"));
    }
}