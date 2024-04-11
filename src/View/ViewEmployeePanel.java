package View;

import Model.*;
import Model.Entity.Client;
import Model.Entity.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewEmployeePanel extends JPanel
{
    public JTable tableEmployee;

    public ViewEmployeePanel()
    {
        super();

        tableEmployee = new JTable();
        tableEmployee.setModel(new ModelTableEmployee(new ArrayList<>()));
        tableEmployee.setColumnModel(new ModelColumnTableEmployee());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableEmployee);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Employee :"));
        this.add(jScrollPane);
    }
}