package View;

import javax.swing.*;

import Controler.GestWindow;
import Model.MainData;

import java.awt.*;

public class EmployeeWindow extends JDialog
{
    public static void main(String[] args)
    {
    }

    public CreateArticleTypePanel articleTypePanel;
    public AddArticlePanel articlePanel;
    public CreateProviderPanel providerPanel;
    public PurchasePanel purchasePanel;

    public EmployeeWindow(JFrame parent, boolean modal)
    {
        super(parent, "Project Market : Employee", modal);

        MainWindow main = (MainWindow) this.getParent();
        this.articleTypePanel = new CreateArticleTypePanel(main.data);
        this.articlePanel = new AddArticlePanel(main.data);
        this.providerPanel = new CreateProviderPanel(main.data);
        this.purchasePanel = new PurchasePanel(main.data);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(2,2));

        mainPanel.add(articleTypePanel);
        mainPanel.add(articlePanel);
        mainPanel.add(providerPanel);
        mainPanel.add(purchasePanel);

        this.setSize(250, 250);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        pack(); // Resize the elements properly
    }
}
