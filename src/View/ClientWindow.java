package View;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JDialog
{
    public ClientWindow(JFrame parent, boolean modal)
    {
        super(parent,"Project Market : Client", modal);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(2,1));

        MainWindow main = (MainWindow) this.getParent();

        mainPanel.add(new BuyArticlePanel(main.data));
        mainPanel.add(new ViewPurchasePanel(main.data.getListPurchase()));

        this.setSize(600, 600);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());
    }
}
