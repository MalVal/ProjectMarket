package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import View.ClientWindow;
import View.MainWindow;

public class ClientButtonListener implements ActionListener
{
    private MainWindow mainWindow;

    public ClientButtonListener(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e)
    {
        ClientWindow cw = new ClientWindow(mainWindow, true);
        cw.setVisible(true);
        cw.dispose();
    }
}