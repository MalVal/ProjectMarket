package Model;

import Model.Entity.*;

import java.io.File;
import java.util.ArrayList;

public interface DataAccessLayer
{
    void addArticle(Article article);
    boolean addArticleType(ArticleType articleType);
    boolean addClient(Client client);
    boolean addEmployee(Employee employee);
    boolean addProvider(Provider provider);
    void addPurchase(Purchase purchase);

    void deleteArticle(Article article);
    void deleteArticleType(ArticleType articleType);
    void deleteClient(Client client);
    void deleteEmployee(Employee employee);
    void deleteProvider(Provider provider);

    void ModifyArticleType(ArticleType oldArticleType, ArticleType newArticleType);
    void ModifyClient(Client oldClient, Client newClient);
    void ModifyEmployee(Employee oldEmployee, Employee newEmployee);
    void ModifyProvider(Provider oldProvider, Provider newProvider);

    void decreaseQuantity(Article article);

    Client searchClient(String registrationNumber);
    Employee searchEmployee(String registrationNumber);
    boolean checkClientPassword(String registrationNumber, String password);
    boolean checkEmployeePassword(String registrationNumber, String password);

    void setCurrentClient(Client client);
    CurrentClient getCurrentClient();
    void addToBasket(Article article);
    void removeToBasket(Article article);

    ArrayList<Article> getListArticle();
    ArrayList<ArticleType> getListArticleType();
    ArrayList<Client> getListClient();
    ArrayList<Employee> getListEmployee();
    ArrayList<Provider> getListProvider();
    ArrayList<Purchase> getListPurchase();

    void exportArticleType(ArticleType articleType, File file);
    boolean importArticleType(File file);
    public String getDarkTheme();
    public void setDarkTheme(String value);
}