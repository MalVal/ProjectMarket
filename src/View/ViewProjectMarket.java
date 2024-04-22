package View;

import Controller.Controller;
import Model.Entity.*;

import java.util.ArrayList;

public interface ViewProjectMarket
{
    void displayError(String error);
    void displayEmployeeWindow();
    void displayClientWindow();
    void displayEmployeeArticleType(ArrayList<ArticleType> articleTypes);
    void displayEmployeeProvider(ArrayList<Provider> providers);
    void displayEmployeeArticle(ArrayList<Article> articles);
    void displayEmployeePurchase(ArrayList<Purchase> purchases);
    void displayEmployeeClient(ArrayList<Client> clients);
    void displayEmployeeEmployee(ArrayList<Employee> employees);
    void displayEmployeeComboBoxArticleType(ArrayList<ArticleType> articleTypes);
    void displayEmployeeComboBoxProvider(ArrayList<Provider> providers);
    void displayClientComboBoxArticle(ArrayList<Article> articles);
    void displayClientBasket(ArrayList<Article> articles);
    void displayClientPurchase(ArrayList<Purchase> purchases);

    Article displayModifyArticle();
    ArticleType displayModifyArticleType(ArticleType articleTypeToModify);
    Provider displayModifyProvider();
    Employee displayModifyEmployee();
    Client displayModifyClient();

    String getRegistrationNumber();
    char[] getPassword();
    String getMode();
    ArticleType getArticleType();
    Provider getProvider();
    Article getEmployeeArticle();
    Client getClient();
    Employee getEmployee();
    Article getClientArticle();

    Article getSelectedEmployeeArticle();
    Article getSelectedClientArticle();
    ArticleType getSelectedArticleType();
    Provider getSelectedProvider();
    Client getSelectedClient();
    Employee getSelectedEmployee();

    void setController(Controller c);
    Controller getController();
    void run();
}