package View.Panel;

import Controller.ControllerActions;
import Model.Entity.Client;
import Model.Entity.Employee;
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

public class CreateEmployeePanel extends JPanel
{
    public JTextField textFieldRegistrationNumber;
    public JTextField textFieldSurName;
    public JTextField textFieldFirstname;
    public JDatePickerImpl datePickerBirthdate;
    public JTextField textFieldSalary;
    public JTextField textFieldPassword;
    public JLabel labelError;
    private JButton btnCreate;

    public EmployeeWindow parent;

    public Employee employee;

    public CreateEmployeePanel(EmployeeWindow parent)
    {
        super();

        this.employee = new Employee();

        this.parent = parent;

        textFieldSurName = new JTextField();
        textFieldFirstname = new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        datePickerBirthdate = new JDatePickerImpl(datePanel, null);
        textFieldSalary = new JTextField();
        textFieldRegistrationNumber = new JTextField();
        textFieldPassword = new JTextField();
        labelError = new JLabel();
        btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(4,1));

        JPanel subPanel = new JPanel(new GridLayout(6, 2));
        subPanel.add(new JLabel("Registration number :"));
        subPanel.add(textFieldRegistrationNumber);
        subPanel.add(new JLabel("Surname :"));
        subPanel.add(textFieldSurName);
        subPanel.add(new JLabel("Firstname :"));
        subPanel.add(textFieldFirstname);
        subPanel.add(new JLabel("Birthdate :"));
        subPanel.add(datePickerBirthdate);
        subPanel.add(new JLabel("Salary :"));
        subPanel.add(textFieldSalary);
        subPanel.add(new JLabel("Password :"));
        subPanel.add(textFieldPassword);

        this.add(new JLabel("Create a new employee :"));
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
                    employee.setRegistrationNumber(textFieldRegistrationNumber.getText());
                    employee.setName(textFieldSurName.getText());
                    employee.setFirstname(textFieldFirstname.getText());

                    if(model.getValue() != null)
                    {
                        Instant instant = model.getValue().toInstant();
                        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                        LocalDate localDate = localDateTime.toLocalDate();
                        employee.setBirthdate(localDate);
                    }

                    employee.setSalary(Double.parseDouble(textFieldSalary.getText()));
                    employee.setPassword(textFieldPassword.getText());

                    parent.main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD_EMPLOYEE));
                    employee = new Employee();
                    textFieldRegistrationNumber.setText("");
                    textFieldSurName.setText("");
                    textFieldFirstname.setText("");
                    textFieldSalary.setText("");
                    textFieldPassword.setText("");
                    model.setValue(null);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Invalid salary !", "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}