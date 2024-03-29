package Model;

import java.util.ArrayList;
import java.util.List;

public class Purchase
{
    public static void main(String[] args)
    {

    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private Client buyer;
    private ArrayList<Article> listArticle;
    private double total;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Purchase(Client buyer, ArrayList<Article> listArticle)
    {
        this.buyer = buyer;
        this.listArticle = listArticle;
        this.total = 0;
        for (Article a : listArticle)
        {
            this.total += a.getType().getPrice();
        }
    }

    public Purchase()
    {
        this(new Client(), new ArrayList<Article>());
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public Client getBuyer()
    {
        return buyer;
    }

    public List<Article> getListArticle()
    {
        return listArticle;
    }

    public double getTotal()
    {
        return total;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setBuyer(Client buyer)
    {
        this.buyer = buyer;
    }

    public void setListArticle(ArrayList<Article> listArticle)
    {
        this.listArticle = listArticle;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }
}
