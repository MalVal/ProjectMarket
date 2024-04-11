package View.ViewPanel;

import Model.ModelColumnTable.ModelColumnTableArticleType;
import Model.ModelTable.ModelTableArticleType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewArticleTypePanel extends JPanel
{
    public JTable tableArticleType;

    public ViewArticleTypePanel()
    {
        super();

        tableArticleType = new JTable();
        tableArticleType.setModel(new ModelTableArticleType(new ArrayList<>()));
        tableArticleType.setColumnModel(new ModelColumnTableArticleType());

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(tableArticleType);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Article type :"));
        this.add(jScrollPane);
    }
}