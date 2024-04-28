package Model.Entity;

import java.time.LocalDate;

public class Employee extends Person implements Cloneable
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee("azdaz", "Malchair", "Valentin", LocalDate.parse("2004-09-11"), "123", 1025.65);
        Employee e3 = e2.clone();

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private double salary;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Employee(String registrationNumber, String name, String firstname, LocalDate birthdate, String password, double salary)
    {
        super(registrationNumber, name, firstname, birthdate, password);
        this.salary = salary;
    }

    public Employee()
    {
        this(null, "Unknown", "Unknown", LocalDate.parse("2000-01-01"), "default", 0);
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public double getSalary()
    {
        return this.salary;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public Employee clone()
    {
        try {
            return (Employee) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new InternalError(e);
        }
    }

}
