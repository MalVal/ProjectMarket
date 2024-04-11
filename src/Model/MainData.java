package Model;

import Model.Entity.*;

import java.util.ArrayList;

public class MainData
{

    public static void main(String[] args)
    {

    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private ArrayList<ArticleType> listArticleType;
    private ArrayList<Article> listArticle;
    private ArrayList<Provider> listProvider;
    private ArrayList<Purchase> listPurchase;
    private ArrayList<Client> listClient;
    private ArrayList<Employee> listEmployee;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public MainData(ArrayList<ArticleType> listArticleType, ArrayList<Article> listArticle, ArrayList<Provider> listProvider, ArrayList<Purchase> listPurchase, ArrayList<Client> listClient, ArrayList<Employee> listEmployee)
    {
        this.listArticleType = listArticleType;
        this.listArticle = listArticle;
        this.listProvider = listProvider;
        this.listPurchase = listPurchase;
        this.listClient = listClient;
        this.listEmployee = listEmployee;
    }

    public MainData()
    {
        this(new ArrayList<ArticleType>(), new ArrayList<Article>(), new ArrayList<Provider>(), new ArrayList<Purchase>(), new ArrayList<Client>(), new ArrayList<Employee>());
    }

    /*----------------------------

        GETTERS

    ----------------------------*/
    public ArrayList<Purchase> getListPurchase()
    {
        return listPurchase;
    }

    public ArrayList<ArticleType> getListArticleType()
    {
        return listArticleType;
    }

    public ArrayList<Article> getListArticle()
    {
        return listArticle;
    }

    public ArrayList<Provider> getListProvider()
    {
        return listProvider;
    }

    public ArrayList<Client> getListClient()
    {
        return listClient;
    }

    public ArrayList<Employee> getListEmployee() {
        return listEmployee;
    }

    /*----------------------------

        METHODS

     ----------------------------*/

    public void addArticle(Article a)
    {
        for(Article article : listArticle)
        {
            if(article.getType().equals(a.getType()))
            {
                article.addQuantity(a.getQuantity());
                return;
            }
        }
        Article newArticle = (Article) a.clone();
        listArticle.add(newArticle);
    }

    public boolean removeArticle(Article a)
    {
        boolean ok;
        for(Article article : listArticle)
        {
            if(article.getType().equals(a.getType()))
            {
                ok = article.removeQuantity(a.getQuantity());
                return ok;
            }
        }
        return false;
    }
}
