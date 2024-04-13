package View.Employee;

import View.Panel.CreateProviderPanel;
import View.ViewPanel.ViewProviderPanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeProviderPanel extends JPanel
{
    public EmployeeWindow parent;
    public ViewProviderPanel viewProviderPanel;
    public CreateProviderPanel createProviderPanel;

    public EmployeeProviderPanel(EmployeeWindow parent)
    {
        super();

        this.parent = parent;
        this.viewProviderPanel = new ViewProviderPanel();
        this.createProviderPanel = new CreateProviderPanel(this.parent);

        this.setLayout(new GridLayout(3,1));

        this.add(viewProviderPanel);
        JButton btnDelete = new JButton("Delete selected provider");
        this.add(btnDelete);
        this.add(createProviderPanel);
    }
}