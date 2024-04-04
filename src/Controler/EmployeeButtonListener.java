package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import View.ClientWindow;
import View.EmployeeWindow;
import View.MainWindow;

public class EmployeeButtonListener implements ActionListener
{
    private MainWindow mainWindow;

    public EmployeeButtonListener(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e)
    {
        EmployeeWindow ew = new EmployeeWindow(mainWindow, true);
        ew.setVisible(true);
        ew.dispose();
    }
}