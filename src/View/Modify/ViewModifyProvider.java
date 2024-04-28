package View.Modify;

import Model.Entity.Provider;

import javax.swing.*;
import java.awt.*;

public class ViewModifyProvider  extends JDialog {

    public JTextField textNameModify;

    public JTextField textAddressModify;

    public JTextField textPhoneNumberModify;

    private Provider newProvider;

    public ViewModifyProvider(JFrame parent, Provider providerToModify) {
        super(parent, "Employee : Modify provider", true);

        newProvider = providerToModify.clone();

        JLabel labelNameModify = new JLabel("Name :");
        this.textNameModify = new JTextField();
        JPanel panelNameModify = new JPanel(new GridLayout(1, 2));
        panelNameModify.add(labelNameModify);
        panelNameModify.add(textNameModify);

        JLabel labelAddressModify = new JLabel("Address :");
        this.textAddressModify = new JTextField();
        JPanel panelAddressModify = new JPanel(new GridLayout(1, 2));
        panelAddressModify.add(labelAddressModify);
        panelAddressModify.add(textAddressModify);

        JLabel labelPhoneNumberModify = new JLabel("PhoneNumber :");
        this.textPhoneNumberModify = new JTextField();
        JPanel panelPhoneNumberModify = new JPanel(new GridLayout(1, 2));
        panelPhoneNumberModify.add(labelPhoneNumberModify);
        panelPhoneNumberModify.add(textPhoneNumberModify);

        JButton btnOkMod = new JButton("ok");
        JButton btnCancelMod = new JButton("cancel");
        JPanel panelBtnModify = new JPanel(new GridLayout(1, 2));
        panelBtnModify.add(btnOkMod);
        panelBtnModify.add(btnCancelMod);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.add(panelNameModify);
        mainPanel.add(panelAddressModify);
        mainPanel.add(panelPhoneNumberModify);
        mainPanel.add(panelBtnModify);


        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        btnOkMod.addActionListener(e -> {
            boolean change = false;

            if (!textNameModify.getText().isEmpty()) {
                newProvider.setName(textNameModify.getText());
                change = true;
            }
            if (!textAddressModify.getText().isEmpty()) {
                newProvider.setAddress(textAddressModify.getText());
                change = true;
            }
            if (!textPhoneNumberModify.getText().isEmpty()) {
                newProvider.setPhoneNumber(textPhoneNumberModify.getText());
                change = true;
            }
            if (!change) {
                newProvider = null;
            }
            dispose();
        });

        btnCancelMod.addActionListener(e -> {
            newProvider = null;
            dispose();
        });
    }

    public Provider showDialog() {
        setVisible(true);
        return this.newProvider;
    }
}