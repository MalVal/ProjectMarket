package Controller;

import Model.DataAccessLayer;
import Model.Entity.*;
import View.ViewProjectMarket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class Controller implements ActionListener
{
    private final DataAccessLayer model;
    private final ViewProjectMarket view;

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
        switch (e.getActionCommand())
        {
            /*

                CONNECTION

            */
            case ControllerActions.CONNECTION:

                char[] password = view.getPassword();
                String strPassword = new String(password);

                // If the checkbox is checked, set the dark theme
                if(view.getColor().equals("Dark"))
                {
                    view.setDarkTheme();
                }
                // Else set the white theme
                else
                {
                    view.setWhiteTheme();
                }

                // Check if all the text boxes are filled
                if(view.getRegistrationNumber().isEmpty() || strPassword.isEmpty())
                {
                    view.displayError("You have to fill all the properties !");
                }
                else
                {
                    // If the user wants to connect as a client
                    if(view.getMode().equals("Client"))
                    {
                        // Search if the client exists
                        Client currentClient = model.searchClient(view.getRegistrationNumber());

                        // If the client exists
                        if(currentClient != null)
                        {
                            // Check if the password is correct
                            if(model.checkClientPassword(view.getRegistrationNumber(), strPassword))
                            {
                                this.model.setCurrentClient(currentClient);
                                this.model.getCurrentClient().getBasket().clear();

                                view.createClientWindow();
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
                    // If the user wants to connect as an employee
                    else if(view.getMode().equals("Employee"))
                    {
                        // Search if the employee exists
                        Employee employee = model.searchEmployee(view.getRegistrationNumber());

                        // If the employee exists
                        if(employee != null)
                        {
                            // Check if the password is correct
                            if(model.checkEmployeePassword(view.getRegistrationNumber(), strPassword))
                            {
                                view.createEmployeeWindow();
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
                break;

            /*

                EMPLOYEE

            */

            // If the user (employee) wants to add an article type
            case ControllerActions.ADD_ARTICLE_TYPE:
                if(model.addArticleType(view.getArticleType()))
                {
                    view.displayEmployeeArticleType(model.getListArticleType());
                    view.displayEmployeeComboBoxArticleType(model.getListArticleType());
                }
                else
                {
                    view.displayError("Article type already exists !");
                }
                break;

            // If the user (employee) wants to add a provider
            case ControllerActions.ADD_PROVIDER:
                if(model.addProvider(view.getProvider()))
                {
                    view.displayEmployeeProvider(model.getListProvider());
                    view.displayEmployeeComboBoxProvider(model.getListProvider());
                }
                else
                {
                    view.displayError("Provider already exists !");
                }
                break;

            // If the user (employee) wants to add an article
            case ControllerActions.ADD_ARTICLE:
                model.addArticle(view.getEmployeeArticle());
                view.displayEmployeeArticle(model.getListArticle());
                break;

            // If the user (employee) wants to add a client
            case ControllerActions.ADD_CLIENT:
                if(model.addClient(view.getClient()))
                {
                    view.displayEmployeeClient(model.getListClient());
                }
                else
                {
                    view.displayError("Client already exists !");
                }
                break;

            // If the user (employee) wants to add an employee
            case ControllerActions.ADD_EMPLOYEE:
                if(model.addEmployee(view.getEmployee()))
                {
                    view.displayEmployeeEmployee(model.getListEmployee());
                }
                else
                {
                    view.displayError("Employee already exists !");
                }
                break;

            // If the user (employee) wants to delete an article
            case ControllerActions.DELETE_ARTICLE:
                // Take the selected article
                Article articleToDelete = view.getSelectedEmployeeArticle();

                // If nothing was selected
                if(articleToDelete == null)
                {
                    view.displayError("You have to select an article !");
                }
                else
                {
                    model.deleteArticle(articleToDelete);
                    view.displayEmployeeArticle(model.getListArticle());
                }
                break;

            // If the user (employee) wants to delete an article type
            case ControllerActions.DELETE_ARTICLE_TYPE:
                // Take the selected article type
                ArticleType articleTypeToDelete = view.getSelectedArticleType();

                // If nothing was selected
                if(articleTypeToDelete == null)
                {
                    view.displayError("You have to select an article type !");
                }
                else
                {
                    model.deleteArticleType(articleTypeToDelete);
                    view.displayEmployeeArticleType(model.getListArticleType());
                    view.displayEmployeeComboBoxArticleType(model.getListArticleType());
                }
                break;

            // If the user (employee) wants to delete a provider
            case ControllerActions.DELETE_PROVIDER:
                // Take the selected provider
                Provider providerToDelete = view.getSelectedProvider();

                // If nothing was selected
                if(providerToDelete == null)
                {
                    view.displayError("You have to select a provider !");
                }
                else
                {
                    model.deleteProvider(providerToDelete);
                    view.displayEmployeeProvider(model.getListProvider());
                    view.displayEmployeeComboBoxProvider(model.getListProvider());
                }
                break;

            // If the user (employee) wants to delete a client
            case ControllerActions.DELETE_CLIENT:
                // Take the selected client
                Client clientToDelete = view.getSelectedClient();

                // If nothing was selected
                if(clientToDelete == null)
                {
                    view.displayError("You have to select a client !");
                }
                else
                {
                    model.deleteClient(clientToDelete);
                    view.displayEmployeeClient(model.getListClient());
                }
                break;

            // If the user (employee) wants to delete an employee
            case ControllerActions.DELETE_EMPLOYEE:
                // Take the selected employee
                Employee employeeToDelete = view.getSelectedEmployee();

                // If nothing was selected
                if(employeeToDelete == null)
                {
                    view.displayError("You have to select an employee !");
                }
                else
                {
                    if(employeeToDelete.getRegistrationNumber().equals("admin"))
                    {
                        view.displayError("You can't delete the admin !");
                    }
                    else
                    {
                        model.deleteEmployee(employeeToDelete);
                        view.displayEmployeeEmployee(model.getListEmployee());
                    }
                }
                break;

            // If the user (employee) wants to modify an article type
            case ControllerActions.MODIFY_ARTICLE_TYPE:
                // Take the selected article type
                ArticleType articleTypeToModify = view.getSelectedArticleType();

                // If nothing was selected
                if(articleTypeToModify == null)
                {
                    view.displayError("You have to select an article type !");
                }
                else
                {
                    ArticleType newArticleType = view.displayModifyArticleType(articleTypeToModify);
                    if(newArticleType != null)
                    {
                        model.ModifyArticleType(articleTypeToModify, newArticleType);

                        view.displayEmployeeArticleType(model.getListArticleType());
                        view.displayEmployeeComboBoxArticleType(model.getListArticleType());
                    }
                }
                break;

            // If the user (employee) wants to modify a client
            case ControllerActions.MODIFY_CLIENT:
                // Take the selected client
                Client clientToModify = view.getSelectedClient();

                // If nothing was selected
                if(clientToModify == null)
                {
                    view.displayError("You have to select a client !");
                }
                else
                {
                    Client newClient = view.displayModifyClient(clientToModify);
                    if(newClient != null)
                    {
                        model.ModifyClient(clientToModify, newClient);

                        view.displayEmployeeClient(model.getListClient());
                    }
                }
                break;

            // If the user (employee) wants to modify an employee
            case ControllerActions.MODIFY_EMPLOYEE:
                // Take the selected employee
                Employee employeeToModify = view.getSelectedEmployee();

                // If nothing was selected
                if(employeeToModify == null)
                {
                    view.displayError("You have to select an employee !");
                }
                else
                {
                    if(employeeToModify.getRegistrationNumber().equals("admin"))
                    {
                        view.displayError("You can't modify the admin !");
                    }
                    else
                    {
                        Employee newEmployee = view.displayModifyEmployee(employeeToModify);
                        if(newEmployee != null)
                        {
                            model.ModifyEmployee(employeeToModify, newEmployee);

                            view.displayEmployeeEmployee(model.getListEmployee());
                        }
                    }
                }
                break;

            // If the user (employee) wants to modify a provider
            case ControllerActions.MODIFY_PROVIDER:
                // Take the selected provider
                Provider providerToModify = view.getSelectedProvider();

                // If nothing was selected
                if(providerToModify == null)
                {
                    view.displayError("You have to select a provider !");
                }
                else
                {
                    Provider newProvider = view.displayModifyProvider(providerToModify);
                    if(newProvider != null)
                    {
                        model.ModifyProvider(providerToModify, newProvider);

                        view.displayEmployeeProvider(model.getListProvider());
                        view.displayEmployeeComboBoxProvider(model.getListProvider());
                    }
                }
                break;

            /*

                CLIENT

            */

            // If the user (client) wants to add an article in his basket
            case ControllerActions.ADD_TO_BASKET:
                model.addToBasket(view.getClientArticle());
                view.displayClientBasket(model.getCurrentClient().getBasket().getList());
                break;

            // If the user (client) wants to remove an article of his basket
            case ControllerActions.REMOVE_TO_BASKET:
                Article articleToRemove = view.getSelectedClientArticle();

                if(articleToRemove == null)
                {
                    view.displayError("You have to select an article !");
                }
                else
                {
                    model.removeToBasket(articleToRemove);
                    view.displayClientBasket(model.getCurrentClient().getBasket().getList());
                }
                break;

            // If the user (client) wants to buy his basket
            case ControllerActions.BUY_BASKET:
                boolean error = false;

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
                        view.displayClientBasket(model.getCurrentClient().getBasket().getList());
                        view.displayClientComboBoxArticle(model.getListArticle());
                    }
                }
                break;
        }
    }
}
