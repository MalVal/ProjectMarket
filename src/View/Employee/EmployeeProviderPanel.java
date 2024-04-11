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

        this.setLayout(new GridLayout(2,1));

        this.add(viewProviderPanel);
        this.add(createProviderPanel);
    }
}