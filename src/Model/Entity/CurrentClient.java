package Model.Entity;

import java.util.ArrayList;

public class CurrentClient
{
    private Client client;
    private Basket basket;
    private ArrayList<Purchase> listPurchases;

    public CurrentClient(Client client, ArrayList<Purchase> listPurchases)
    {
        this.client = client;
        this.basket = new Basket();
        this.listPurchases = listPurchases;
    }

    public Basket getBasket()
    {
        return this.basket;
    }

    public ArrayList<Purchase> getListPurchases() {
        ArrayList<Purchase> copy = new ArrayList<>();
        for (Purchase p:listPurchases) {
            copy.add(p.clone());
        }
        return copy;
    }
}
