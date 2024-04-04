package View;

import javax.swing.*;
import java.awt.*;

import Controler.ClientButtonListener;
import Controler.EmployeeButtonListener;
import Controler.GestWindow;
import Model.MainData;

public class MainWindow extends JFrame
{
    public static void main(String[] args)
    {
    }

    public MainData data;

    public MainWindow(MainData data)
    {
        super();

        this.data = data;

        JButton btnClient = new JButton("Client");
        btnClient.addActionListener(new ClientButtonListener(this));

        JButton btnEmployee = new JButton("Employee");
        btnEmployee.addActionListener(new EmployeeButtonListener(this));

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(1,2));
        mainPanel.add(btnClient);
        mainPanel.add(btnEmployee);

        this.setTitle("Project Market");
        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        // Events
        this.addWindowListener(new GestWindow());
    }
}
