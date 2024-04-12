package View.Client;

import View.Panel.BuyArticlePanel;
import View.ViewProjectMarketSwing;
import View.ViewPanel.ViewPurchasePanel;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JDialog
{
    public BuyArticlePanel buyArticlePanel;
    public ViewPurchasePanel viewPurchasePanel;

    public ClientWindow(JFrame parent, boolean modal)
    {
        super(parent,"Project Market : Client", modal);

        this.buyArticlePanel = new BuyArticlePanel();
        this.viewPurchasePanel = new ViewPurchasePanel();

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(2,1));

        ViewProjectMarketSwing main = (ViewProjectMarketSwing) this.getParent();

        mainPanel.add(buyArticlePanel);
        mainPanel.add(viewPurchasePanel);

        this.setSize(600, 600);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());
    }
}
