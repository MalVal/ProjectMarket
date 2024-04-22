package View;

import Controller.Controller;
import Controller.ControllerActions;
import Model.Entity.*;
import Model.ModelColumnTable.*;
import Model.ModelTable.*;
import View.Client.ClientWindow;
import View.Employee.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import View.Modify.ViewModifyArticleType;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class ViewProjectMarketSwing extends JFrame implements ViewProjectMarket
{
    public Controller controller;

    private ClientWindow cw;
    private EmployeeWindow ew;

    public JTextField textRegistrationNumberConnexion;
    public JPasswordField textPasswordConnexion;
    public JRadioButton radioClientConnection;
    public JRadioButton radioEmploysConnection;

    public ViewProjectMarketSwing()
    {
        super();

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        cw = new ClientWindow(this, true);
        ew = new EmployeeWindow(this, true);

        ButtonGroup buttonGroup = new ButtonGroup();

        JLabel labelRegistrationNumberConnexion = new JLabel("Registration number :");
        this.textRegistrationNumberConnexion = new JTextField();
        JPanel panelRegistrationNumberCo =new JPanel(new GridLayout(1,2));
        panelRegistrationNumberCo.add(labelRegistrationNumberConnexion);
        panelRegistrationNumberCo.add(textRegistrationNumberConnexion);

        JLabel labelPasswordConnexion = new JLabel("Password:");
        this.textPasswordConnexion = new JPasswordField();
        JPanel panelPasswordCo =new JPanel(new GridLayout(1,2));
        panelPasswordCo.add(labelPasswordConnexion);
        panelPasswordCo.add(textPasswordConnexion);

        this.radioClientConnection = new JRadioButton("Client:");
        this.radioEmploysConnection = new JRadioButton("Employee:");
        JPanel radioPanel = new JPanel(new GridLayout( 1, 2 ));

        radioPanel.add(radioEmploysConnection);
        buttonGroup.add(radioEmploysConnection);
        radioPanel.add(radioClientConnection);
        buttonGroup.add(radioClientConnection);


        JButton btnConnection = new JButton("Connection");

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(panelRegistrationNumberCo);
        mainPanel.add(panelPasswordCo);
        mainPanel.add(radioPanel);
        mainPanel.add(btnConnection);

        this.setTitle("Project Market");
        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        // Events
        btnConnection.addActionListener(new ActionListener()
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
    public void displayClientComboBoxArticle(ArrayList<Article> articles)
    {
        cw.addArticleBasketPanel.articleComboBoxModel.update(articles);
    }

    @Override
    public void displayClientBasket(ArrayList<Article> articles) {
        cw.viewArticlePanel.tableArticle.setModel(new ModelTableArticle(articles));
        cw.viewArticlePanel.tableArticle.setColumnModel(new ModelColumnTableArticle());
    }

    @Override
    public void displayClientPurchase(ArrayList<Purchase> purchases) {
        cw.viewPurchasePanel.tablePurchase.setModel(new ModelTablePurchase(purchases));
        cw.viewPurchasePanel.tablePurchase.setColumnModel(new ModelColumnTablePurchase());
    }

    @Override
    public Article displayModifyArticle() {
        return null;
    }

    @Override
    public ArticleType displayModifyArticleType(ArticleType articleTypeToModify) {
        ArticleType a;
        ViewModifyArticleType dialog = new ViewModifyArticleType(this, articleTypeToModify);
        a = dialog.showDialog();
        return a;
    }

    @Override
    public Provider displayModifyProvider() {
        return null;
    }

    @Override
    public Employee displayModifyEmployee() {
        return null;
    }

    @Override
    public Client displayModifyClient() {
        return null;
    }

    @Override
    public String getRegistrationNumber() {
        return textRegistrationNumberConnexion.getText();
    }

    @Override
    public char[] getPassword() {
        return textPasswordConnexion.getPassword();
    }

    @Override
    public String getMode() {
        if(radioClientConnection.isSelected())
        {
            return "Client";
        }
        else if(radioEmploysConnection.isSelected())
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
    public Article getEmployeeArticle() {
        return this.ew.employeeArticlePanel.addArticlePanel.article;
    }

    @Override
    public Client getClient() {
        return this.ew.employeeClientPanel.createClientPanel.client;
    }

    @Override
    public Employee getEmployee() {
        return this.ew.employeeEmployeePanel.createEmployeePanel.employee;
    }

    @Override
    public Article getClientArticle() {
        return this.cw.addArticleBasketPanel.article;
    }

    @Override
    public Article getSelectedEmployeeArticle() {
        JTable table = ew.employeeArticlePanel.viewArticlePanel.tableArticle;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (Article)(table.getModel().getValueAt(index, -1));
    }

    @Override
    public Article getSelectedClientArticle() {
        JTable table = cw.viewArticlePanel.tableArticle;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (Article)(table.getModel().getValueAt(index, -1));
    }

    @Override
    public ArticleType getSelectedArticleType() {
        JTable table = ew.employeeArticleTypePanel.viewArticleTypePanel.tableArticleType;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (ArticleType) (table.getModel().getValueAt(index, -1));
    }

    @Override
    public Provider getSelectedProvider() {
        JTable table = ew.employeeProviderPanel.viewProviderPanel.tableProvider;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (Provider) (table.getModel().getValueAt(index, -1));
    }

    @Override
    public Client getSelectedClient() {
        JTable table = ew.employeeClientPanel.viewClientPanel.tableClient;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (Client) (table.getModel().getValueAt(index, -1));
    }

    @Override
    public Employee getSelectedEmployee() {
        JTable table = ew.employeeEmployeePanel.viewEmployeePanel.tableEmployee;
        int index = table.getSelectedRow();
        if (index == -1) return null;

        return (Employee)(table.getModel().getValueAt(index, -1));
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
