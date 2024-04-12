package View.Panel;

import View.Employee.EmployeeWindow;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
    import java.awt.*;
import java.util.Properties;

public class CreateEmployeePanel extends JPanel
{
    public JTextField textFieldRegistrationNumber;
    public JTextField textFieldSurName;
    public JTextField textFieldFirstname;
    public JDatePickerImpl datePickerBirthdate;
    public JTextField textFieldSalary;
    public JLabel labelError;
    private JButton btnCreate;

    public EmployeeWindow parent;

    public CreateEmployeePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;

        textFieldSurName = new JTextField();
        textFieldFirstname = new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        datePickerBirthdate = new JDatePickerImpl(datePanel, null);
        textFieldSalary = new JTextField();
        textFieldRegistrationNumber = new JTextField();
        labelError = new JLabel();
        btnCreate = new JButton("Create");

        this.setLayout(new GridLayout(4,1));

        JPanel subPanel = new JPanel(new GridLayout(5, 2));
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

        this.add(new JLabel("Create a new employee :"));
        this.add(subPanel);
        this.add(labelError);
        this.add(btnCreate);
    }
}