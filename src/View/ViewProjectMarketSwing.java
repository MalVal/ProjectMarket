package View;

import Controller.Controller;
import Controller.ControllerActions;
import Model.*;
import Model.Entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ViewProjectMarketSwing extends JFrame implements ViewProjectMarket
{
    public Controller controller;

    private ClientWindow cw;
    private EmployeeWindow ew;

    public JTextField textNameConnexion;
    public JTextField textFirstnameConnexion;
    public JPasswordField textPasswordConnexion;
    public JRadioButton radioClientConnexion;
    public JRadioButton radioEmploysConnexion;
    public JLabel labelError;

    public ViewProjectMarketSwing()
    {
        super();

        cw = new ClientWindow(this, true);
        ew = new EmployeeWindow(this, true);

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
        btnConnexion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.actionPerformed(new ActionEvent(this, 0, ControllerActions.CONNECTION));
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void displayError(String error) {
        JOptionPane.showMessageDialog(getParent(), error, "Error !", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void displayEmployeeWindow() {
        ew.setVisible(true);
        ew.dispose();
    }

    @Override
    public void displayClientWindow() {
        cw.setVisible(true);
        cw.dispose();
    }

    @Override
    public void displayEmployeeArticleType(ArrayList<ArticleType> articleTypes) {
        ew.employeeArticleTypePanel.viewArticleTypePanel.tableArticleType.setModel(new ModelTableArticleType(articleTypes));
        ew.employeeArticleTypePanel.viewArticleTypePanel.tableArticleType.setColumnModel(new ModelColumnTableArticleType());
    }

    @Override
    public void displayEmployeeProvider(ArrayList<Provider> providers) {
        ew.employeeProviderPanel.viewProviderPanel.tableProvider.setModel(new ModelTableProvider(providers));
        ew.employeeProviderPanel.viewProviderPanel.tableProvider.setColumnModel(new ModelColumnTableProvider());
    }

    @Override
    public void displayEmployeeArticle(ArrayList<Article> articles) {
        ew.employeeArticlePanel.viewArticlePanel.tableArticle.setModel(new ModelTableArticle(articles));
        ew.employeeArticlePanel.viewArticlePanel.tableArticle.setColumnModel(new ModelColumnTableArticle());
    }

    @Override
    public void displayEmployeePurchase(ArrayList<Purchase> purchases) {
        ew.viewPurchasePanel.tablePurchase.setModel(new ModelTablePurchase(purchases));
        ew.viewPurchasePanel.tablePurchase.setColumnModel(new ModelColumnTablePurchase());
    }

    @Override
    public void displayEmployeeClient(ArrayList<Client> clients) {
        ew.employeeClientPanel.viewClientPanel.tableClient.setModel(new ModelTableClient(clients));
        ew.employeeClientPanel.viewClientPanel.tableClient.setColumnModel(new ModelColumnTableClient());
    }

    @Override
    public void displayEmployeeEmployee(ArrayList<Employee> employees) {
        ew.employeeEmployeePanel.viewEmployeePanel.tableEmployee.setModel(new ModelTableEmployee(employees));
        ew.employeeEmployeePanel.viewEmployeePanel.tableEmployee.setColumnModel(new ModelColumnTableEmployee());
    }

    @Override
    public void displayEmployeeComboBoxArticleType(ArrayList<ArticleType> articleTypes) {
        ew.employeeArticlePanel.addArticlePanel.articleTypeComboBoxModel.update(articleTypes);
    }

    @Override
    public void displayEmployeeComboBoxProvider(ArrayList<Provider> providers) {
        ew.employeeArticlePanel.addArticlePanel.providerComboBoxModel.update(providers);
    }

    @Override
    public String getFirstname() {
        return textFirstnameConnexion.getText();
    }

    @Override
    public String getSurname() {
        return textNameConnexion.getText();
    }

    @Override
    public char[] getPassword() {
        return textPasswordConnexion.getPassword();
    }

    @Override
    public String getMode() {
        if(radioClientConnexion.isSelected())
        {
            return "Client";
        }
        else if(radioEmploysConnexion.isSelected())
        {
            return "Employee";
        }
        return "Error";
    }

    @Override
    public ArticleType getArticleType() {
        return this.ew.employeeArticleTypePanel.createArticleTypePanel.articleType;
    }

    @Override
    public Provider getProvider() {
        return this.ew.employeeProviderPanel.createProviderPanel.provider;
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
