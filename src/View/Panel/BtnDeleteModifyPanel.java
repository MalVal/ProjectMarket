package View.Panel;

import javax.swing.*;
import java.awt.*;

public class BtnDeleteModifyPanel extends JPanel
{
    public JButton btnDelete;
    public JButton btnModify;

    public BtnDeleteModifyPanel(String textDelete, String textModify)
    {
        super();

        btnDelete = new JButton(textDelete);
        btnModify = new JButton(textModify);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);

        // Add JButton delete
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical

        this.add(btnDelete, constraints);
        // Add JButton modify
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.weighty = 0.1; // 10% de l'espace vertical
        this.add(btnModify, constraints);
    }
}
