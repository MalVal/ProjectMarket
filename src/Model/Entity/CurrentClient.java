package Model.Entity;

import java.util.ArrayList;

public class CurrentClient
{
    private Client client;
    private Basket basket;

    public CurrentClient(Client client)
    {
        this.client = client;
        this.basket = new Basket();
    }

    public Basket getBasket()
    {
        return this.basket;
    }
}
