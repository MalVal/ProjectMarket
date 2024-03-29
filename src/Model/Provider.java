package Model;

public class Provider implements Cloneable
{
    public static void main(String[] args)
    {
        Provider p1 = new Provider();
        Provider p2 = new Provider("Lidl", "Rue de la cité", "0499/87/75/42");
        Provider p3 = (Provider) p2.clone();

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private String name;
    private String address;
    private String phoneNumber;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Provider(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Provider()
    {
        this("Unknown", "Unknown", "Unknown");
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Name : " + this.name + " Address : " + this.address + " Phone number : " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Provider p = (Provider) obj;
        return this.name.equals(p.name) && this.address.equals(p.address) && this.phoneNumber.equals(p.phoneNumber);
    }

    @Override
    public Object clone()
    {
        return new Provider(this.name, this.address, this.phoneNumber);
    }

}
