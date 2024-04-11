package Model.ModelTable;

import Model.Entity.ArticleType;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelTableArticleType extends AbstractTableModel
{
    private ArrayList<ArticleType> articleTypes;
    public ModelTableArticleType(ArrayList<ArticleType> articleTypes)
    {
        this.articleTypes = articleTypes;
    }

    @Override
    public Class getColumnClass(int c)
    {
        if (c == 0) return String.class;
        if (c == 1) return String.class;
        if (c == 2) return Double.class;
        return null;
    }

    @Override
    public int getRowCount()
    {
        return articleTypes.size();
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        ArticleType articleType = articleTypes.get(l);
        if (c == 0) return articleType.getName();
        if (c == 1) return articleType.getCategory();
        if (c == 2) return articleType.getPrice();
        return null;
    }
}
