package View.Panel;

import Controller.ControllerActions;
import Model.Entity.Client;
import View.CustomDateFormat;
import View.Employee.EmployeeWindow;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;

public class CreateClientPanel extends JPanel
{
    public JTextField textFieldRegistrationNumber;
    public JTextField textFieldSurName;
    public JTextField textFieldFirstname;
    public JDatePickerImpl datePickerBirthdate;
    public JTextField textFieldDiscount;
    public JTextField textFieldPassword;

    public EmployeeWindow parent;

    public Client client;

    public CreateClientPanel(EmployeeWindow parent)
    {
        super();

        this.client = new Client();

        this.parent = parent;

        textFieldRegistrationNumber = new JTextField();
        textFieldSurName = new JTextField();
        textFieldFirstname = new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        datePickerBirthdate = new JDatePickerImpl(datePanel, new CustomDateFormat());
        textFieldDiscount = new JTextField();
        textFieldPassword = new JTextField();
        JButton btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(3,1));

        JPanel subPanel = new JPanel(new GridLayout(6, 2));
        subPanel.add(new JLabel("Registration number : "));
        subPanel.add(textFieldRegistrationNumber);
        subPanel.add(new JLabel("Surname :"));
        subPanel.add(textFieldSurName);
        subPanel.add(new JLabel("Firstname :"));
        subPanel.add(textFieldFirstname);
        subPanel.add(new JLabel("Birthdate :"));
        subPanel.add(datePickerBirthdate);
        subPanel.add(new JLabel("Discount :"));
        subPanel.add(textFieldDiscount);
        subPanel.add(new JLabel("Password :"));
        subPanel.add(textFieldPassword);

        this.add(new JLabel("Create a new client :"));
        this.add(subPanel);
        this.add(btnCreate);

        btnCreate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(textFieldRegistrationNumber.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid registration number !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    client.setRegistrationNumber(textFieldRegistrationNumber.getText());

                    if(textFieldSurName.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid name !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    client.setName(textFieldSurName.getText());

                    if(textFieldFirstname.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid firstname !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    client.setFirstname(textFieldFirstname.getText());

                    if(model.getValue() == null)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid birthdate !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Instant instant = model.getValue().toInstant();
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                    LocalDate localDate = localDateTime.toLocalDate();
                    client.setBirthdate(localDate);

                    double discount = Double.parseDouble(textFieldDiscount.getText());
                    if(discount < 0)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid discount (can't be negative) !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    client.setDiscount(discount);

                    if(textFieldPassword.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid password !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    client.setPassword(textFieldPassword.getText());

                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_CLIENT));
                    client = new Client();
                    textFieldRegistrationNumber.setText("");
                    textFieldSurName.setText("");
                    textFieldFirstname.setText("");
                    textFieldDiscount.setText("");
                    textFieldPassword.setText("");
                    model.setValue(null);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Invalid discount !", "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}