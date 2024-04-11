package Model.Entity;

import java.time.LocalDate;

public class Client extends Person implements Cloneable
{
    public static void main(String[] args)
    {
        Client c1 = new Client();
        Client c2 = new Client("Malchair", "Valentin", LocalDate.parse("2004-09-11"), "1545320", 8.9);
        Client c3 = (Client) c2.clone();

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

    public Client(String name, String firstname, LocalDate birthdate, String password, double discount)
    {
        super(name, firstname, birthdate, password);
        this.discount = discount;
    }

    public Client()
    {
        this("Unknown", "Unknown", LocalDate.parse("2000-01-01"), "default", 0);
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

    public void setRegistrationNumber(double discount)
    {
        this.discount = discount;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Name : " + this.getName() + " Firstname : " + this.getFirstname() + " Birthdate : " + this.getBirthdate().toString() + " Discount : " + this.discount;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Client c = (Client) obj;
        return Double.compare(this.discount, c.discount) == 0;
    }

    @Override
    public Object clone()
    {
        return new Client(this.getName(), this.getFirstname(), this.getBirthdate(), this.getPassword(), this.discount);
    }

}
