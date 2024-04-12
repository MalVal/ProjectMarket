package Model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Purchase implements Cloneable
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
        return buyer.clone();
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

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Buyer : " + this.getBuyer() + " List article(s) : " + this.listArticle.toString() + " Total : " + this.total;
    }

    @Override
    public Purchase clone()
    {
        return new Purchase(this.buyer, this.listArticle);
    }

}
