package Model.Entity;

import java.util.ArrayList;

public class CurrentClient
{
    private Client client;
    private final Basket basket;
    private ArrayList<Purchase> purchases;

    public CurrentClient()
    {
        this.client = new Client();
        this.basket = new Basket();
        this.purchases = new ArrayList<>();
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public void setPurchases(ArrayList<Purchase> purchases)
    {
        this.purchases = purchases;
    }

    public Client getClient()
    {
        return this.client.clone();
    }

    public ArrayList<Purchase> getPurchases()
    {
        ArrayList<Purchase> copy = new ArrayList<>();
        for (Purchase p:purchases) {
            copy.add(p.clone());
        }
        return copy;
    }

    public Basket getBasket()
    {
        return this.basket;
    }
}
