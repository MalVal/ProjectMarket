package View.Employee;

import View.Panel.CreateEmployeePanel;
import View.ViewPanel.ViewEmployeePanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeEmployeePanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewEmployeePanel viewEmployeePanel;
    public CreateEmployeePanel createEmployeePanel;

    public EmployeeEmployeePanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewEmployeePanel = new ViewEmployeePanel();
        this.createEmployeePanel = new CreateEmployeePanel(this.parent);

        this.setLayout(new GridLayout(2,1));

        this.add(viewEmployeePanel);
        this.add(createEmployeePanel);
    }
}