package Controller;

import Model.DataAccessLayer;
import View.ViewProjectMarket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Controller implements ActionListener
{
    private DataAccessLayer model;
    private ViewProjectMarket view;

    public Controller(DataAccessLayer model, ViewProjectMarket view)
    {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void run()
    {
        view.run();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals(ControllerActions.CONNECTION))
        {
            char[] password = view.getPassword();
            String strPassword = new String(password);
            if(view.getFirstname().isEmpty() || view.getSurname().isEmpty() || strPassword.isEmpty())
            {
                view.displayError("You have to fill all the properties !");
            }
            else
            {
                if(view.getMode().equals("Client"))
                {
                    view.displayClientComboBoxArticle(model.getListArticle());
                    view.displayClientWindow();
                    return;
                }
                else if(view.getMode().equals("Employee"))
                {
                    view.displayEmployeeArticleType(model.getListArticleType());
                    view.displayEmployeeProvider(model.getListProvider());
                    view.displayEmployeeArticle(model.getListArticle());
                    view.displayEmployeePurchase(model.getListPurchase());
                    view.displayEmployeeClient(model.getListClient());
                    view.displayEmployeeEmployee(model.getListEmployee());
                    view.displayEmployeeComboBoxArticleType(model.getListArticleType());
                    view.displayEmployeeComboBoxProvider(model.getListProvider());
                    view.displayEmployeeWindow();
                    return;
                }
                else
                {
                    view.displayError("You have to check a radio button !");
                }
            }
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_ARTICLE_TYPE))
        {
            if(model.addArticleType(view.getArticleType()))
            {
                view.displayEmployeeArticleType(model.getListArticleType());
                view.displayEmployeeComboBoxArticleType(model.getListArticleType());
            }
            else
            {
                view.displayError("Article type already exists !");
            }
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_PROVIDER))
        {
            if(model.addProvider(view.getProvider()))
            {
                view.displayEmployeeProvider(model.getListProvider());
                view.displayEmployeeComboBoxProvider(model.getListProvider());
            }
            else
            {
                view.displayError("Provider already exists !");
            }
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_ARTICLE))
        {
            model.addArticle(view.getArticle());
            view.displayClientComboBoxArticle(model.getListArticle());
            view.displayEmployeeArticle(model.getListArticle());
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_PURCHASE))
        {
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_CLIENT))
        {
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_EMPLOYEE))
        {
            return;
        }

    }
}
