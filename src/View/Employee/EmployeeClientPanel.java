package View.Employee;

import View.Panel.CreateClientPanel;
import View.ViewPanel.ViewClientPanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeClientPanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewClientPanel viewClientPanel;
    public CreateClientPanel createClientPanel;

    public EmployeeClientPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewClientPanel = new ViewClientPanel();
        this.createClientPanel = new CreateClientPanel(this.parent);

        this.setLayout(new GridLayout(3,1));

        this.add(viewClientPanel);
        JButton btnDelete = new JButton("Delete selected client");
        this.add(btnDelete);
        this.add(createClientPanel);
    }
}