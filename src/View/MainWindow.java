package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Controler.GestWindow;

public class MainWindow extends JFrame
{
    public static void main(String[] args)
    {
        MainWindow mw =  new MainWindow();
        mw.setVisible(true);
    }

    public MainWindow()
    {
        super();

        JButton btnClient = new JButton("Client");
        JButton btnEmployee = new JButton("Employee");

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
