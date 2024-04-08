package View;

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
        this.viewClientPanel = new ViewClientPanel(this.parent.main.data.getListClient());
        this.createClientPanel = new CreateClientPanel(this.parent);

        this.setLayout(new GridLayout(2,1));

        this.add(viewClientPanel);
        this.add(createClientPanel);
    }
}