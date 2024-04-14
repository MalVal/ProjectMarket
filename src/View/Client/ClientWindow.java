package View.Client;

import Controller.ControllerActions;
import Model.Entity.Article;
import Model.Entity.ArticleType;
import Model.Entity.Provider;
import View.Panel.AddArticleBasketPanel;
import View.ViewPanel.ViewArticlePanel;
import View.ViewProjectMarket;
import View.ViewProjectMarketSwing;
import View.ViewPanel.ViewPurchasePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JDialog
{
    public AddArticleBasketPanel addArticleBasketPanel;
    public ViewPurchasePanel viewPurchasePanel;
    public ViewArticlePanel viewArticlePanel;

    public ViewProjectMarket main;

    public ClientWindow(JFrame parent, boolean modal)
    {
        super(parent,"Project Market : Client", modal);

        this.main = (ViewProjectMarket) this.getParent();

        this.addArticleBasketPanel = new AddArticleBasketPanel(this);
        this.viewPurchasePanel = new ViewPurchasePanel();
        this.viewArticlePanel = new ViewArticlePanel();

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(4,1));

        mainPanel.add(addArticleBasketPanel);
        mainPanel.add(viewArticlePanel);
        JButton btnBuy = new JButton("Buy");
        mainPanel.add(btnBuy);
        mainPanel.add(viewPurchasePanel);

        this.setSize(800, 800);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        btnBuy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.getController().actionPerformed(new ActionEvent(this, 0, ControllerActions.BUY_BASKET));
            }
        });
    }
}
