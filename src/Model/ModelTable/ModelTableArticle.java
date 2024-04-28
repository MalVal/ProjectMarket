package Model.ModelTable;

import Model.Entity.Article;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelTableArticle extends AbstractTableModel
{
    private final ArrayList<Article> articles;
    public ModelTableArticle(ArrayList<Article> articles)
    {
        this.articles = articles;
    }

    @Override
    public Class getColumnClass(int c)
    {
        return switch (c) {
            case 0, 1 -> String.class;
            case 2 -> Integer.class;
            default -> Object.class;
        };
    }

    @Override
    public int getRowCount()
    {
        return articles.size();
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Article article = articles.get(l);
        if (c == -1) return article;
        if (c == 0) return article.getType().toString();
        if (c == 1) return article.getProvider().toString();
        if (c == 2) return article.getQuantity();
        return null;
    }
}
