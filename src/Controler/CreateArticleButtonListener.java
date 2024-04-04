package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ArticleType;
import View.CreateArticleTypePanel;
import View.EmployeeWindow;
import View.MainWindow;

public class CreateArticleButtonListener implements ActionListener
{
    private CreateArticleTypePanel ui;

    public CreateArticleButtonListener(CreateArticleTypePanel ui)
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
            ui.articleTypeList.add(newArticleType);
            ui.parent.articlePanel.articleTypeComboBoxModel.addElementAndUpdate(newArticleType);
            ui.labelError.setText("Type created !");
        }
        catch (NumberFormatException exception)
        {
            ui.labelError.setText("The price have to be numeric !");
        }
    }
}