package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import View.ClientWindow;
import View.EmployeeWindow;
import View.MainWindow;

public class ConnectionButtonListener implements ActionListener
{
    private MainWindow mainWindow;

    public ConnectionButtonListener(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e)
    {
        char[] password = mainWindow.textPasswordConnexion.getPassword();
        String strPassword = new String(password);
        if(mainWindow.textNameConnexion.getText().isEmpty() || mainWindow.textFirstnameConnexion.getText().isEmpty() || strPassword.isEmpty())
        {
            mainWindow.labelError.setText("You have to fill all the properties !");
        }
        else
        {
            if(mainWindow.radioClientConnexion.isSelected())
            {
                // Client
                ClientWindow cw = new ClientWindow(mainWindow, true);
                cw.setVisible(true);
                cw.dispose();
            }
            else if(mainWindow.radioEmploysConnexion.isSelected())
            {
                // Employee
                EmployeeWindow ew = new EmployeeWindow(mainWindow, true);
                ew.setVisible(true);
                ew.dispose();
            }
            else
            {
                mainWindow.labelError.setText("You have to check a radio button !");
            }
        }
    }
}