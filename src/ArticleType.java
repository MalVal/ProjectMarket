import java.time.LocalDate;

public class ArticleType implements Cloneable
{
    public static void main(String[] args)
    {
        ArticleType at1 = new ArticleType();
        ArticleType at2 = new ArticleType("Apple", "Fruit", 0.56);
        ArticleType at3 = (ArticleType) at2.clone();

        System.out.println("at1 = " + at1);
        System.out.println("at2 = " + at2);
        System.out.println("at3 = " + at3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private String name;
    private String category;
    private double price;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public ArticleType(String name, String category, double price)
    {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public ArticleType()
    {
        this("Unknown", "Unknown", 0);
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public String getName()
    {
        return this.name;
    }

    public String getCategory()
    {
        return this.category;
    }

    public double getPrice()
    {
        return this.price;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return "Name : " + this.getName() + " Category : " + this.category + " Price : " + this.price;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ArticleType at = (ArticleType) obj;
        return this.name.equals(at.name) && this.category.equals(at.category) && Double.compare(this.price, at.price) == 0;
    }

    @Override
    public Object clone()
    {
        return new ArticleType(this.name, this.category, this.price);
    }

}
