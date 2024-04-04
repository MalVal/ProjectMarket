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

    public EmployeeWindow(JFrame parent, boolean modal)
    {
        super(parent, "Project Market : Employee", modal);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(2,2));

        MainWindow main = (MainWindow) this.getParent();

        mainPanel.add(new CreateArticleTypePanel());
        mainPanel.add(new AddArticlePanel());
        mainPanel.add(new CreateProviderPanel());
        mainPanel.add(new PurchasePanel(main.data.getListPurchase()));

        this.setSize(250, 250);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        pack(); // Resize the elements properly
    }
}
