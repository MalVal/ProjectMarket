package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Entity.ArticleType;
import Model.ModelTableArticleType;
import View.CreateArticleTypePanel;

public class CreateArticleTypeButtonListener implements ActionListener
{
    private CreateArticleTypePanel ui;

    public CreateArticleTypeButtonListener(CreateArticleTypePanel ui)
    {
        this.ui = ui;
    }

    public void actionPerformed(ActionEvent e)
    {
        String name = ui.textFieldName.getText();
        String category = ui.textFieldCategory.getText();
        String priceString = ui.textFieldPrice.getText();

        if(name.isEmpty() || category.isEmpty() || priceString.isEmpty())
        {
            ui.labelError.setText("You have to fill all the properties !");
            return;
        }

        try
        {
            double price = Double.parseDouble(priceString);

            for(ArticleType articleType : ui.articleTypeList)
            {
                if(articleType.getName().equals(name))
                {
                    ui.labelError.setText("Type already exists !");
                    return;
                }
            }
            ArticleType newArticleType = new ArticleType(name, category, price);
            ui.articleTypeList.add(newArticleType); // Add the new type to the list
            ui.parent.employeeArticlePanel.addArticlePanel.articleTypeComboBoxModel.addElementAndUpdate(newArticleType); // Prevent the combo box
            // Prevent the Jtable
            ModelTableArticleType tm = (ModelTableArticleType) ui.parent.employeeArticleTypePanel.viewArticleTypePanel.tableArticleType.getModel();
            tm.fireTableDataChanged();

            ui.labelError.setText("Type created !");
        }
        catch (NumberFormatException exception)
        {
            ui.labelError.setText("The price have to be numeric !");
        }
    }
}