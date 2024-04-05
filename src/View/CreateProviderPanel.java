package View;

import javax.swing.*;
import java.awt.*;

public class CreateProviderPanel extends JPanel
{
    private JTextField textFieldName;
    private  JTextField textFieldAddress;
    private JTextField textFieldPhoneNumber;
    public EmployeeWindow parent;

    public CreateProviderPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;

        textFieldName = new JTextField();
        textFieldAddress = new JTextField();
        textFieldPhoneNumber = new JTextField();

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(3, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(textFieldName);
        subPanel.add(new JLabel("Address :"));
        subPanel.add(textFieldAddress);
        subPanel.add(new JLabel("Phone number :"));
        subPanel.add(textFieldPhoneNumber);

        this.add(new JLabel("Create a new provider :"));
        this.add(subPanel);
        this.add(new JButton("Create"));
    }
}