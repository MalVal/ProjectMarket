package Controller;

import Model.DataAccessLayer;
import Model.Entity.Article;
import Model.Entity.Client;
import Model.Entity.Employee;
import Model.Entity.Purchase;
import View.ViewProjectMarket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
            if(view.getRegistrationNumber().isEmpty() || strPassword.isEmpty())
            {
                view.displayError("You have to fill all the properties !");
            }
            else
            {
                if(view.getMode().equals("Client"))
                {
                    Client currentClient = model.searchClient(view.getRegistrationNumber());

                    if(currentClient != null)
                    {
                        if(model.checkClientPassword(view.getRegistrationNumber(), strPassword))
                        {
                            this.model.setCurrentClient(currentClient);
                            this.model.getCurrentClient().getBasket().clear();

                            view.displayClientComboBoxArticle(model.getListArticle());
                            view.displayClientBasket(model.getCurrentClient().getBasket().getList());
                            view.displayClientPurchase(model.getCurrentClient().getPurchases());
                            view.displayClientWindow();
                        }
                        else
                        {
                            view.displayError("Wrong password !");
                        }
                    }
                    else
                    {
                        view.displayError("Client doesn't exists !");
                    }
                }
                else if(view.getMode().equals("Employee"))
                {
                    Employee employee = model.searchEmployee(view.getRegistrationNumber());

                    if(employee != null)
                    {
                        if(model.checkEmployeePassword(view.getRegistrationNumber(), strPassword))
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
                        }
                        else
                        {
                            view.displayError("Wrong password !");
                        }
                    }
                    else
                    {
                        view.displayError("Employee doesn't exists !");
                    }

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

        if (e.getActionCommand().equals(ControllerActions.ADD_CLIENT))
        {
            if(model.addClient(view.getClient()))
            {
                view.displayEmployeeClient(model.getListClient());
            }
            else
            {
                view.displayError("Client already exists !");
            }
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_EMPLOYEE))
        {
            if(model.addEmployee(view.getEmployee()))
            {
                view.displayEmployeeEmployee(model.getListEmployee());
            }
            else
            {
                view.displayError("Employee already exists !");
            }
            return;
        }

        if (e.getActionCommand().equals(ControllerActions.ADD_TO_BASKET))
        {
            model.addToBasket(view.getClientArticle());
            view.displayClientBasket(model.getCurrentClient().getBasket().getList());
        }

        if (e.getActionCommand().equals(ControllerActions.BUY_BASKET))
        {
            boolean error = false;
            ArrayList<Article> articleToDelete = new ArrayList<>();

            if(model.getCurrentClient().getBasket().getList().isEmpty())
            {
                view.displayError("The basket is empty !");
            }
            else
            {
                for(Article articleBasket : model.getCurrentClient().getBasket().getList())
                {
                    for(Article articleStock : model.getListArticle())
                    {
                        if(articleStock.equals(articleBasket))
                        {
                            if(articleStock.getQuantity() - articleBasket.getQuantity() < 0)
                            {
                                error = true;
                                break;
                            }
                        }
                    }
                    if(error)
                        break;
                }

                if(error)
                {
                    view.displayError("The quantity of one of the items exceeds the available quantity");
                }
                else
                {
                    Purchase purchase = new Purchase(model.getCurrentClient().getClient(), model.getCurrentClient().getBasket().getList());

                    for(Article articleBasket : model.getCurrentClient().getBasket().getList())
                    {
                        model.decreaseQuantity(articleBasket);
                        model.getCurrentClient().getBasket().removeArticle(articleBasket);
                    }

                    model.addPurchase(purchase);

                    ArrayList<Purchase> purchases = new ArrayList<>();

                    for(Purchase p : model.getListPurchase())
                    {
                        if(p.getBuyer().equals(model.getCurrentClient().getClient()))
                        {
                            purchases.add(p);
                        }
                    }
                    model.getCurrentClient().setPurchases(purchases);

                    view.displayClientPurchase(model.getCurrentClient().getPurchases());
                    view.displayEmployeePurchase(model.getListPurchase());
                    view.displayClientBasket(model.getCurrentClient().getBasket().getList());
                    view.displayClientComboBoxArticle(model.getListArticle());
                }
            }
        }
    }
}
