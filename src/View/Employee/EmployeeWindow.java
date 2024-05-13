package View.Employee;

import Controller.ControllerActions;
import View.ViewProjectMarket;
import View.ViewPanel.ViewPurchasePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeWindow extends JDialog
{
    public EmployeeArticleTypePanel employeeArticleTypePanel;
    public EmployeeArticlePanel employeeArticlePanel;
    public EmployeeProviderPanel employeeProviderPanel;
    public ViewPurchasePanel viewPurchasePanel;
    public EmployeeClientPanel employeeClientPanel;
    public EmployeeEmployeePanel employeeEmployeePanel;

    public ViewProjectMarket main;

    public EmployeeWindow(JFrame parent, boolean modal)
    {
        super(parent, "Project Market : Employee", modal);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportArticle = new JMenuItem("Export article");
        JMenuItem importArticle = new JMenuItem("Import article");
        JMenuItem exitItem = new JMenuItem("Exit");

        exportArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.EXPORT_ARTICLE));
            }
        });
        importArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.IMPORT_ARTICLE));
            }
        });
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exportArticle);
        fileMenu.add(importArticle);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        this.setJMenuBar(menuBar);
        this.setSize(800, 800);

        this.main = (ViewProjectMarket) this.getParent();

        this.employeeArticleTypePanel = new EmployeeArticleTypePanel(this);
        this.employeeArticlePanel = new EmployeeArticlePanel(this);
        this.employeeProviderPanel = new EmployeeProviderPanel(this);
        this.viewPurchasePanel = new ViewPurchasePanel();
        this.employeeClientPanel = new EmployeeClientPanel(this);
        this.employeeEmployeePanel = new EmployeeEmployeePanel(this);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Article type", employeeArticleTypePanel);
        tabbedPane.addTab("Article", employeeArticlePanel);
        tabbedPane.addTab("Provider", employeeProviderPanel);
        tabbedPane.addTab("Purchase", viewPurchasePanel);
        tabbedPane.addTab("Client", employeeClientPanel);
        tabbedPane.addTab("Employee", employeeEmployeePanel);

        JPanel mainPanel = (JPanel) this.getContentPane();

        mainPanel.add(tabbedPane);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());
    }
}
