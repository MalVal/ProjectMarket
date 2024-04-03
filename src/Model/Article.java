package Model;

public class Article implements Cloneable
{
    public static void main(String[] args)
    {
        Article a1 = new Article();
        Article a2 = new Article(new ArticleType("Banana", "Fruit", 0.98), new Provider("CocoFruits", "Rue du centre 01", "0499/84/85/72"), 15);
        Article a3 = (Article) a2.clone();

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }

    /*----------------------------

        VARIABLES

     ----------------------------*/

    private ArticleType type;
    private Provider provider;
    private int quantity;

    /*----------------------------

        CONSTRUCTORS

     ----------------------------*/

    public Article(ArticleType type, Provider provider, int quantity)
    {
        this.type = type;
        this.provider = provider;
        this.quantity = quantity;
    }

    public Article()
    {
        this(new ArticleType(), new Provider(), 1);
    }

    /*----------------------------

        GETTERS

     ----------------------------*/

    public ArticleType getType()
    {
        return this.type;
    }

    public Provider getProvider()
    {
        return this.provider;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    /*----------------------------

        SETTERS

     ----------------------------*/

    public void setType(ArticleType type)
    {
        this.type = type;
    }

    public void setProvider(Provider provider)
    {
        this.provider = provider;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /*----------------------------

        METHODS

     ----------------------------*/

    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }

    public boolean removeQuantity(int quantity)
    {
        if(this.quantity - quantity >= 0)
        {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

    /*----------------------------

        OVERRIDE

     ----------------------------*/

    @Override
    public String toString()
    {
        return this.type.toString() + " " + this.provider.toString() + " Quantity : " + this.quantity;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Article a = (Article) obj;
        return this.type.equals(a.type) && this.provider.equals(a.provider) && this.quantity == a.quantity;
    }

    @Override
    public Object clone()
    {
        return new Article(this.type, this.provider, this.quantity);
    }

}
