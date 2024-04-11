package Model.Entity;

import java.time.LocalDate;

public abstract class Person
{
    public static void main(String[] args)
    {

    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private String name;
    private String firstname;
    private LocalDate birthdate;
    private String password;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Person(String name, String firstname, LocalDate birthdate, String password)
    {
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.password = password;
    }

    public Person()
    {
        this("Unknown", "Unknown", LocalDate.parse("2000-01-01"), "default");
    }

    /*----------------------------

        GETTERS

     ----------------------------*/
    public String getName()
    {
        return this.name;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public LocalDate getBirthdate()
    {
        return this.birthdate;
    }

    public String getPassword() {
        return this.password;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setName(String name)
    {
        this.name = name;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setBirthdate(LocalDate birthdate)
    {
        this.birthdate = birthdate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Name : " + this.name + " Firstname : " + this.firstname + " Birthdate : " + this.birthdate.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person p = (Person)obj;
        return this.name.equals(p.name) && this.firstname.equals(p.firstname) && this.birthdate.equals(p.birthdate);
    }

}
