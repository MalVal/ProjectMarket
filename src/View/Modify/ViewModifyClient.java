package View.Modify;

import Model.Entity.Client;
import Model.Entity.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewModifyClient extends JDialog
{


    public JTextField textNameModify;

    public JTextField textfirstnameModify;

    public JTextField textpasswordModify;

    public JTextField textdiscountModify;
    private Client newClient;
    public ViewModifyClient(JFrame parent, Client clientToModify)
    {
        super(parent,"Employee : Modify provider", true);

        newClient = clientToModify.clone();

        JLabel labelNameModify = new JLabel("Name :");
        this.textNameModify = new JTextField();
        JPanel panelNameModify =new JPanel(new GridLayout(1,2));
        panelNameModify.add(labelNameModify);
        panelNameModify.add(textNameModify);

        JLabel labelfirstnameModify = new JLabel("firstname :");
        this.textfirstnameModify = new JTextField();
        JPanel panelfirstnameModify =new JPanel(new GridLayout(1,2));
        panelfirstnameModify.add(labelfirstnameModify);
        panelfirstnameModify.add(textfirstnameModify);

        JLabel labelpasswordModify = new JLabel("password :");
        this.textpasswordModify = new JTextField();
        JPanel panelpasswordModify =new JPanel(new GridLayout(1,2));
        panelpasswordModify.add(labelpasswordModify);
        panelpasswordModify.add(textpasswordModify);

        JLabel labeldiscountModify = new JLabel("discount :");
        this.textdiscountModify = new JTextField();
        JPanel paneldiscountModify =new JPanel(new GridLayout(1,2));
        paneldiscountModify.add(labeldiscountModify);
        paneldiscountModify.add(textdiscountModify);

        JButton btnOkMod = new JButton("ok");
        JButton btnCancelMod = new JButton("cancel");
        JPanel panelBtnModify =new JPanel(new GridLayout(1,2));
        panelBtnModify.add(btnOkMod);
        panelBtnModify.add(btnCancelMod);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(5    ,1));
        mainPanel.add(panelNameModify);
        mainPanel.add(panelfirstnameModify);
        mainPanel.add(panelpasswordModify);
        mainPanel.add(paneldiscountModify);
        mainPanel.add(panelBtnModify);


        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        btnOkMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    boolean change = false;

                    if(!textNameModify.getText().isEmpty())
                    {
                        newClient.setName(textNameModify.getText());
                        change = true;
                    }
                    if(!textfirstnameModify.getText().isEmpty())
                    {
                        newClient.setFirstname(textfirstnameModify.getText());
                        change = true;
                    }
                    if(!textpasswordModify.getText().isEmpty())
                    {
                        newClient.setPassword(textpasswordModify.getText());
                        change = true;
                    }
                    if(!textdiscountModify.getText().isEmpty())
                    {
                        double discount = Double.parseDouble(textdiscountModify.getText());
                        if(discount < 0)
                        {
                            JOptionPane.showMessageDialog(getParent(), "Invalid discount (can't be negative) !", "Error !", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        newClient.setDiscount(discount);
                        change = true;
                    }
                    if(!change)
                    {
                        newClient = null;
                    }
                    dispose();
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(getParent(), "Invalid discount !", "Error !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newClient = null;
                dispose();
            }
        });

    }
    public Client showDialog()
    {
        setVisible(true);
        return this.newClient;
    }
}