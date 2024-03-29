package View;

import javax.swing.*;

import Controler.GestWindow;

public class EmployeeWindow extends JFrame
{
    public static void main(String[] args)
    {
        EmployeeWindow ew =  new EmployeeWindow();
        ew.setVisible(true);
    }

    public EmployeeWindow()
    {
        super();

        this.setTitle("Project Market : Employee");
        this.setSize(250, 250);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        // Events
        this.addWindowListener(new GestWindow());
    }
}
