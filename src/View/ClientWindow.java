package View;

import javax.swing.*;

import Controler.GestWindow;

import java.awt.*;

public class ClientWindow extends JDialog
{
    public static void main(String[] args)
    {
    }

    public ClientWindow(JFrame parent, boolean modal)
    {
        super(parent,"Project Market : Client", modal);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(1,1));

        mainPanel.add(new BuyArticlePanel());

        this.setSize(250, 250);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        pack(); // Resize the elements properly
    }
}
