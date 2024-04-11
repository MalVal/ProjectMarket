package Model.Entity;

import java.time.LocalDate;

public class Employee extends Person implements Cloneable
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Malchair", "Valentin", LocalDate.parse("2004-09-11"), "123", 125, 1025.65);
        Employee e3 = (Employee) e2.clone();

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private int registrationNumber;
    private double salary;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Employee(String name, String firstname, LocalDate birthdate, String password, int registrationNumber, double salary)
    {
        super(name, firstname, birthdate, password);
        this.registrationNumber = registrationNumber;
        this.salary = salary;
    }

    public Employee()
    {
        this("Unknown", "Unknown", LocalDate.parse("2000-01-01"), "default", -1, 0);
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public int getRegistrationNumber()
    {
        return this.registrationNumber;
    }

    public double getSalary()
    {
        return this.salary;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setRegistrationNumber(int registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Name : " + this.getName() + " Firstname : " + this.getFirstname() + " Birthdate : " + this.getBirthdate().toString() + " Registration number : " + this.registrationNumber + " Salary : " + this.salary;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Employee e = (Employee) obj;
        return this.registrationNumber == e.registrationNumber && Double.compare(this.salary, e.salary) == 0;
   }

    @Override
    public Object clone()
    {
        return new Employee(this.getName(), this.getFirstname(), this.getBirthdate(), this.getPassword(), this.registrationNumber, this.salary);
    }

}
