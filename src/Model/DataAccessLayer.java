package Model;

import Model.Entity.*;

public interface DataAccessLayer
{
    boolean addArticle(Article article);
    boolean addArticleType(ArticleType articleType);
    boolean addClient(Client client);
    boolean addEmployee(Employee employee);
    boolean addProvider(Provider provider);
    boolean addPurchase(Purchase purchase);
}