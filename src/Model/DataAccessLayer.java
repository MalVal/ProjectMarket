package Model;

import Model.Entity.*;

import java.util.ArrayList;

public interface DataAccessLayer
{
    boolean addArticle(Article article);
    boolean addArticleType(ArticleType articleType);
    boolean addClient(Client client);
    boolean addEmployee(Employee employee);
    boolean addProvider(Provider provider);
    boolean addPurchase(Purchase purchase);

    boolean deleteArticle(Article article);
    boolean deleteArticleType(ArticleType articleType);
    boolean deleteClient(Client client);
    boolean deleteEmployee(Employee employee);
    boolean deleteProvider(Provider provider);

    boolean decreaseQuantity(Article article);

    Client searchClient(String registrationNumber);
    Employee searchEmployee(String registrationNumber);
    boolean checkClientPassword(String registrationNumber, String password);
    boolean checkEmployeePassword(String registrationNumber, String password);

    void setCurrentClient(Client client);
    CurrentClient getCurrentClient();
    void addToBasket(Article article);
    boolean removeToBasket(Article article);

    public ArrayList<Article> getListArticle();
    public ArrayList<ArticleType> getListArticleType();
    public ArrayList<Client> getListClient();
    public ArrayList<Employee> getListEmployee();
    public ArrayList<Provider> getListProvider();
    public ArrayList<Purchase> getListPurchase();
}