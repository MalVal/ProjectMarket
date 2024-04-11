package View;

import javax.swing.*;

public class EmployeeWindow extends JDialog
{
    public EmployeeArticleTypePanel employeeArticleTypePanel;
    public EmployeeArticlePanel employeeArticlePanel;
    public EmployeeProviderPanel employeeProviderPanel;
    public ViewPurchasePanel viewPurchasePanel;
    public EmployeeClientPanel employeeClientPanel;
    public EmployeeEmployeePanel employeeEmployeePanel;

    public MainWindow main;

    public EmployeeWindow(JFrame parent, boolean modal)
    {
        super(parent, "Project Market : Employee", modal);
        this.setSize(600, 600);

        this.main = (MainWindow) this.getParent();

        this.employeeArticleTypePanel = new EmployeeArticleTypePanel(this);
        this.employeeArticlePanel = new EmployeeArticlePanel(this);
        this.employeeProviderPanel = new EmployeeProviderPanel(this);
        this.viewPurchasePanel = new ViewPurchasePanel(this.main.data.getListPurchase());
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
