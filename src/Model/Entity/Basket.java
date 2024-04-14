package Model.Entity;

import java.util.ArrayList;

public class Basket
{
    private ArrayList<Article> basket;

    public Basket()
    {
        this.basket = new ArrayList<>();
    }

    public void addArticle(Article a)
    {
        for(Article article : basket)
        {
            if(article.equals(a))
            {
                int quantity1 = a.getQuantity();
                int quantity2 = article.getQuantity();
                int newQuantity = quantity1 + quantity2;
                article.setQuantity(newQuantity);
                return;
            }
        }
        basket.add(a);
    }

    public boolean removeArticle(Article a)
    {
        return basket.remove((Object)a);
    }

    public ArrayList<Article> getList()
    {
        ArrayList<Article> copy = new ArrayList<>();
        for (Article a:basket) {
            copy.add(a.clone());
        }
        return copy;
    }

    public void clear()
    {
        this.basket.clear();
    }
}
