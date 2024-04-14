package Model;

import Model.Entity.*;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAOProjectMarket implements DataAccessLayer
{
    private CurrentClient currentClient;
    private ArrayList<ArticleType> listArticleType;
    private ArrayList<Article> listArticle;
    private ArrayList<Provider> listProvider;
    private ArrayList<Purchase> listPurchase;
    private ArrayList<Client> listClient;
    private ArrayList<Employee> listEmployee;

    public DAOProjectMarket()
    {
        currentClient = new CurrentClient();
        listArticleType = new ArrayList<>();
        listArticle = new ArrayList<>();
        listProvider = new ArrayList<>();
        listPurchase = new ArrayList<>();
        listClient = new ArrayList<>();
        listEmployee = new ArrayList<>();
        this.addEmployee(new Employee("admin", "---", "---", LocalDate.parse("2004-09-11"), "admin", 0));
    }

    @Override
    public boolean addArticle(Article article) {
        if(article == null) return false;

        for(Article a : listArticle)
        {
            if(a.equals(article))
            {
                int quantity1 = a.getQuantity();
                int quantity2 = article.getQuantity();
                int newQuantity = quantity1 + quantity2;
                a.setQuantity(newQuantity);
                return true;
            }
        }

        listArticle.add(article);
        return true;
    }

    @Override
    public boolean addArticleType(ArticleType articleType) {
        if(articleType == null) return false;

        for(ArticleType at : listArticleType)
        {
            if(at.equals(articleType))
            {
                return false;
            }
        }

        listArticleType.add(articleType);
        return true;
    }

    @Override
    public boolean addClient(Client client) {
        if(client == null) return false;

        for(Client c : listClient)
        {
            if(c.equals(client))
            {
                return false;
            }
        }

        listClient.add(client);
        return true;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(employee == null) return false;

        for(Employee e : listEmployee)
        {
            if(e.equals(employee))
            {
                return false;
            }
        }

        listEmployee.add(employee);
        return true;
    }

    @Override
    public boolean addProvider(Provider provider) {
        if(provider == null) return false;

        for(Provider p : listProvider)
        {
            if(p.equals(provider))
            {
                return false;
            }
        }

        listProvider.add(provider);
        return true;
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        if(purchase == null) return false;
        listPurchase.add(purchase);
        return true;
    }

    @Override
    public boolean deleteArticle(Article article) {
        return listArticle.remove(article);
    }

    @Override
    public boolean deleteArticleType(ArticleType articleType) {
        return listArticleType.remove(articleType);
    }

    @Override
    public boolean deleteClient(Client client) {
        return listClient.remove(client);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return listEmployee.remove(employee);
    }

    @Override
    public boolean deleteProvider(Provider provider) {
        return listProvider.remove(provider);
    }

    @Override
    public Client searchClient(String registrationNumber) {

        for(Client c : listClient)
        {
            if(c.getRegistrationNumber().equals(registrationNumber))
            {
                return c.clone();
            }
        }

        return null;
    }

    @Override
    public Employee searchEmployee(String registrationNumber) {

        for(Employee e : listEmployee)
        {
            if(e.getRegistrationNumber().equals(registrationNumber))
            {
                return e.clone();
            }
        }

        return null;
    }

    @Override
    public boolean checkClientPassword(String registrationNumber, String password) {
        for(Client c : listClient)
        {
            if(c.getRegistrationNumber().equals(registrationNumber))
            {
                if(c.getPassword().equals(password))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkEmployeePassword(String registrationNumber, String password) {
        for(Employee e : listEmployee)
        {
            if(e.getRegistrationNumber().equals(registrationNumber))
            {
                if(e.getPassword().equals(password))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void setCurrentClient(Client client) {
        this.currentClient.setClient(client);
    }

    @Override
    public CurrentClient getCurrentClient() {
        return this.currentClient;
    }

    @Override
    public void addToBasket(Article article) {
        this.currentClient.getBasket().addArticle(article);
    }

    @Override
    public boolean removeToBasket(Article article) {
        return this.currentClient.getBasket().removeArticle(article);
    }

    @Override
    public ArrayList<Article> getListArticle() {
        ArrayList<Article> copy = new ArrayList<>();
        for (Article a:listArticle) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<ArticleType> getListArticleType() {
        ArrayList<ArticleType> copy = new ArrayList<>();
        for (ArticleType a:listArticleType) {
            copy.add((ArticleType) a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Client> getListClient() {
        ArrayList<Client> copy = new ArrayList<>();
        for (Client a:listClient) {
            copy.add((Client) a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Employee> getListEmployee() {
        ArrayList<Employee> copy = new ArrayList<>();
        for (Employee a:listEmployee) {
            copy.add((Employee) a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Provider> getListProvider() {
        ArrayList<Provider> copy = new ArrayList<>();
        for (Provider a:listProvider) {
            copy.add((Provider) a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Purchase> getListPurchase() {
        ArrayList<Purchase> copy = new ArrayList<>();
        for (Purchase a:listPurchase) {
            copy.add((Purchase) a.clone());
        }
        return copy;
    }
}
