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

    String getRegistrationNumber();
    char[] getPassword();
    String getMode();
    ArticleType getArticleType();
    Provider getProvider();
    Article getArticle();
    Client getClient();
    Employee getEmployee();

    void setController(Controller c);
    Controller getController();
    void run();
}