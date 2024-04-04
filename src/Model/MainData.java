package Model;

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

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public MainData(ArrayList<ArticleType> listArticleType, ArrayList<Article> listArticle, ArrayList<Provider> listProvider, ArrayList<Purchase> listPurchase)
    {
        this.listArticleType = listArticleType;
        this.listArticle = listArticle;
        this.listProvider = listProvider;
        this.listPurchase = listPurchase;
    }

    public MainData()
    {
        this(new ArrayList<ArticleType>(), new ArrayList<Article>(), new ArrayList<Provider>(), new ArrayList<Purchase>());
    }

    /*----------------------------

        GETTERS

    ----------------------------*/
    public ArrayList<Purchase> getListPurchase()
    {
        return listPurchase;
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
