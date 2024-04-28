package View.Modify;

import Model.Entity.Employee;

import javax.swing.*;
import java.awt.*;

public class ViewModifyEmployee extends JDialog
{


    public JTextField textNameModify;

    public JTextField textfirstnameModify;

    public JTextField textpasswordModify;

    public JTextField textsalaryModify;
    private Employee newEmployee;
    public ViewModifyEmployee(JFrame parent, Employee employeeToModify)
    {
        super(parent,"Employee : Modify provider", true);

        newEmployee = employeeToModify.clone();

        JLabel labelNameModify = new JLabel("Name :");
        this.textNameModify = new JTextField();
        JPanel panelNameModify =new JPanel(new GridLayout(1,2));
        panelNameModify.add(labelNameModify);
        panelNameModify.add(textNameModify);

        JLabel labelfirstnameModify = new JLabel("firstname :");
        this.textfirstnameModify = new JTextField();
        JPanel panelfirstnameModify =new JPanel(new GridLayout(1,2));
        panelfirstnameModify.add(labelfirstnameModify);
        panelfirstnameModify.add(textfirstnameModify);

        JLabel labelpasswordModify = new JLabel("password :");
        this.textpasswordModify = new JTextField();
        JPanel panelpasswordModify =new JPanel(new GridLayout(1,2));
        panelpasswordModify.add(labelpasswordModify);
        panelpasswordModify.add(textpasswordModify);

        JLabel labelsalaryModify = new JLabel("salary :");
        this.textsalaryModify = new JTextField();
        JPanel panelsalaryModify =new JPanel(new GridLayout(1,2));
        panelsalaryModify.add(labelsalaryModify);
        panelsalaryModify.add(textsalaryModify);

        JButton btnOkMod = new JButton("ok");
        JButton btnCancelMod = new JButton("cancel");
        JPanel panelBtnModify =new JPanel(new GridLayout(1,2));
        panelBtnModify.add(btnOkMod);
        panelBtnModify.add(btnCancelMod);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.add(panelNameModify);
        mainPanel.add(panelfirstnameModify);
        mainPanel.add(panelpasswordModify);
        mainPanel.add(panelsalaryModify);
        mainPanel.add(panelBtnModify);

        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());


        btnOkMod.addActionListener(e -> {
            try
            {
                boolean change = false;

                if(!textNameModify.getText().isEmpty())
                {
                    newEmployee.setName(textNameModify.getText());
                    change = true;
                }
                if(!textfirstnameModify.getText().isEmpty())
                {
                    newEmployee.setFirstname(textfirstnameModify.getText());
                    change = true;
                }
                if(!textpasswordModify.getText().isEmpty())
                {
                    newEmployee.setPassword(textpasswordModify.getText());
                    change = true;
                }
                if(!textsalaryModify.getText().isEmpty())
                {
                    double salary = Double.parseDouble(textsalaryModify.getText());
                    if(salary < 0)
                    {
                        JOptionPane.showMessageDialog(getParent(), "Invalid salary (can't be negative) !", "Error !", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    newEmployee.setSalary(salary);
                    change = true;
                }
                if(!change)
                {
                    newEmployee = null;
                }
                dispose();
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(getParent(), "Invalid salary !", "Error !", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelMod.addActionListener(e -> {
            newEmployee = null;
            dispose();
        });
    }
    public Employee showDialog()
    {
        setVisible(true);
        return this.newEmployee;
    }
}