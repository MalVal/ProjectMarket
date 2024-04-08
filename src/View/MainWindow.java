package View;

import javax.swing.*;
import java.awt.*;

import Controler.ConnectionButtonListener;
import Controler.GestWindow;
import Model.MainData;

public class MainWindow extends JFrame
{
    public MainData data;
    public JTextField textNameConnexion;
    public JTextField textFirstnameConnexion;
    public JPasswordField textPasswordConnexion;
    public JRadioButton radioClientConnexion;
    public JRadioButton radioEmploysConnexion;
    public JLabel labelError;

    public MainWindow(MainData data)
    {
        super();

        this.data = data;

        ButtonGroup buttonGroup = new ButtonGroup();

        JLabel labelNameConnexion = new JLabel("Name:");
        this.textNameConnexion = new JTextField();
        JPanel panelNameco =new JPanel(new GridLayout(1,2));
        panelNameco.add(labelNameConnexion);
        panelNameco.add(textNameConnexion);

        JLabel labelFirstnameConnexion = new JLabel("Firstname:");
        this.textFirstnameConnexion = new JTextField();
        JPanel panelFirstnameco =new JPanel(new GridLayout(1,2));
        panelFirstnameco.add(labelFirstnameConnexion);
        panelFirstnameco.add(textFirstnameConnexion);

        JLabel labelPasswordConnexion = new JLabel("Password:");
        this.textPasswordConnexion = new JPasswordField();
        JPanel panelPasswordco =new JPanel(new GridLayout(1,2));
        panelPasswordco.add(labelPasswordConnexion);
        panelPasswordco.add(textPasswordConnexion);

        this.radioClientConnexion = new JRadioButton("Client:");
        this.radioEmploysConnexion = new JRadioButton("Employee:");
        JPanel radioPanel = new JPanel(new GridLayout( 1, 2 ));

        radioPanel.add(radioEmploysConnexion);
        buttonGroup.add(radioEmploysConnexion);
        radioPanel.add(radioClientConnexion);
        buttonGroup.add(radioClientConnexion);

        this.labelError = new JLabel();

        JButton btnConnexion = new JButton("connexion");

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(6,1));
        mainPanel.add(panelNameco);
        mainPanel.add(panelFirstnameco);
        mainPanel.add(panelPasswordco);
        mainPanel.add(radioPanel);
        mainPanel.add(labelError);
        mainPanel.add(btnConnexion);

        this.setTitle("Project Market");
        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        // Events
        this.addWindowListener(new GestWindow());
        btnConnexion.addActionListener(new ConnectionButtonListener(this));
    }
}
