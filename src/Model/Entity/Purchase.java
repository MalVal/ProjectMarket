package Model.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Purchase implements Cloneable, Serializable
{
    public static void main(String[] args)
    {

    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private Client buyer;
    private final ArrayList<Article> listArticle;
    private double total;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Purchase(Client buyer, ArrayList<Article> listArticle)
    {
        this.buyer = buyer;
        this.listArticle = listArticle;
        this.total = 0;
        for(Article a : listArticle)
        {
            this.total += a.getQuantity() * a.getType().getPrice();
        }
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
        try {
            Purchase clone = (Purchase) super.clone();
            clone.buyer = this.buyer.clone();
            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            throw new InternalError(e);
        }
    }

}
