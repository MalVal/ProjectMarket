package View.Modify;

import Model.Entity.ArticleType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewModifyArticleType extends JDialog
{
    public JTextField textNameModify;

    public JTextField textCategoryModify;

    public JTextField textPriceModify;

    private ArticleType newArticleType;

    public ViewModifyArticleType(JFrame parent, ArticleType articleTypeToModify)
    {
        super(parent, "Employee : Modify article type", true);

        newArticleType = articleTypeToModify.clone();

        JLabel labelNameModify = new JLabel("Name :");
        this.textNameModify = new JTextField();
        JPanel panelNameModify =new JPanel(new GridLayout(1,2));
        panelNameModify.add(labelNameModify);
        panelNameModify.add(textNameModify);

        JLabel labelCategoryModify = new JLabel("Category :");
        this.textCategoryModify = new JTextField();
        JPanel panelCategoryModify =new JPanel(new GridLayout(1,2));
        panelCategoryModify.add(labelCategoryModify);
        panelCategoryModify.add(textCategoryModify);

        JLabel labelPriceModify = new JLabel("Price :");
        this.textPriceModify = new JTextField();
        JPanel panelPriceModify =new JPanel(new GridLayout(1,2));
        panelPriceModify.add(labelPriceModify);
        panelPriceModify.add(textPriceModify);

        JButton btnOkMod = new JButton("Ok");
        JButton btnCancelMod = new JButton("Cancel");
        JPanel panelBtnModify =new JPanel(new GridLayout(1,2));
        panelBtnModify.add(btnOkMod);
        panelBtnModify.add(btnCancelMod);

        JPanel mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(panelNameModify);
        mainPanel.add(panelCategoryModify);
        mainPanel.add(panelPriceModify);
        mainPanel.add(panelBtnModify);

        this.setSize(600, 400);

        // Icon
        ImageIcon icon = new ImageIcon("src/View/img/caddieIcon.png");
        this.setIconImage(icon.getImage());

        btnOkMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnCancelMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newArticleType = null;
                dispose();
            }
        });
    }

    public ArticleType showDialog() {
        setVisible(true);
        return this.newArticleType;
    }
}