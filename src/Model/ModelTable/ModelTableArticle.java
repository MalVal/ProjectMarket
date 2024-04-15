package Model.ModelTable;

import Model.Entity.Article;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelTableArticle extends AbstractTableModel
{
    private ArrayList<Article> articles;
    public ModelTableArticle(ArrayList<Article> articles)
    {
        this.articles = articles;
    }

    @Override
    public Class getColumnClass(int c)
    {
        if (c == 0) return String.class;
        if (c == 1) return String.class;
        if (c == 2) return Integer.class;
        return null;
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
        if (c == 0) return article.getType().toString();
        if (c == 1) return article.getProvider().toString();
        if (c == 2) return article.getQuantity();
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2;
    }
}
