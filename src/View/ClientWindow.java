package View;

import javax.swing.*;

import Controler.GestWindow;

import java.awt.*;

public class ClientWindow extends JDialog
{
    public static void main(String[] args)
    {
        ClientWindow cw =  new ClientWindow();
        cw.setVisible(true);
    }

    public ClientWindow()
    {
        super();

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(1,1));

        mainPanel.add(new BuyArticlePanel());

        this.setTitle("Project Market : Client");
        this.setSize(250, 250);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        // Events
        this.addWindowListener(new GestWindow());

        pack(); // Resize the elements properly
    }
}
