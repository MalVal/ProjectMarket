package Model.Entity;

import java.time.LocalDate;
import java.io.Serializable;

public class Client extends Person implements Cloneable, Serializable
{
    public static void main(String[] args)
    {
        Client c1 = new Client();
        Client c2 = new Client("saqsqsd", "Malchair", "Valentin", LocalDate.parse("2004-09-11"), "1545320", 8.9);
        Client c3 = c2.clone();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private double discount;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Client(String registrationNumber, String name, String firstname, LocalDate birthdate, String password, double discount)
    {
        super(registrationNumber, name, firstname, birthdate, password);
        this.discount = discount;
    }

    public Client()
    {
        this(null, "Unknown", "Unknown", LocalDate.parse("2000-01-01"), "default", 0);
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public double getDiscount()
    {
        return this.discount;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public Client clone()
    {
        try {
            return (Client) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new InternalError(e);
        }
    }

}
