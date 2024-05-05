package Model.Entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable
{

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private String registrationNumber;
    private String name;
    private String firstname;
    private LocalDate birthdate;
    private String password;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Person(String registrationNumber, String name, String firstname, LocalDate birthdate, String password)
    {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.password = password;
    }

    /*----------------------------

        GETTERS

     ----------------------------*/
    public String getRegistrationNumber()
    {
        return this.registrationNumber;
    }

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

    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

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
        return this.getRegistrationNumber() + " " + this.getName() + " " + this.getFirstname();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person p = (Person)obj;
        return this.registrationNumber.equals(p.registrationNumber);
    }

}
