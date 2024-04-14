package Model.Entity;

import java.util.ArrayList;

public class CurrentClient
{
    private Client client;
    private Basket basket;

    public CurrentClient()
    {
        this.client = new Client();
        this.basket = new Basket();
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Client getClient()
    {
        return this.client.clone();
    }

    public Basket getBasket()
    {
        return this.basket;
    }
}
