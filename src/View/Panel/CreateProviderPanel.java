package View.Panel;

import Controller.ControllerActions;
import Model.Entity.Provider;
import View.Employee.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProviderPanel extends JPanel
{
    public JTextField textFieldName;
    public JTextField textFieldAddress;
    public JTextField textFieldPhoneNumber;
    public JLabel labelError;
    public EmployeeWindow parent;

    public Provider provider;

    public CreateProviderPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;

        this.provider = new Provider();

        textFieldName = new JTextField();
        textFieldAddress = new JTextField();
        textFieldPhoneNumber = new JTextField();
        labelError = new JLabel();
        JButton btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(4, 2));
        subPanel.add(new JLabel("Name :"));
        subPanel.add(textFieldName);
        subPanel.add(new JLabel("Address :"));
        subPanel.add(textFieldAddress);
        subPanel.add(new JLabel("Phone number :"));
        subPanel.add(textFieldPhoneNumber);
        subPanel.add(labelError);

        this.add(new JLabel("Create a new provider :"));
        this.add(subPanel);
        this.add(btnCreate);

        btnCreate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                provider.setName(textFieldName.getText());
                provider.setAddress(textFieldAddress.getText());
                provider.setPhoneNumber(textFieldPhoneNumber.getText());
                parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_PROVIDER));
            }
        });
    }
}