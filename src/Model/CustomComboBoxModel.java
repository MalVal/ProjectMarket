package Model;

import javax.swing.*;
import java.util.ArrayList;

public class CustomComboBoxModel<E> extends DefaultComboBoxModel<E> {

    public CustomComboBoxModel(ArrayList<E> items)
    {
        super();
        for (E item : items)
        {
            addElement(item);
        }
    }

    public void addElementAndUpdate(E item)
    {
        addElement(item);
        fireContentsChanged(this, 0, getSize() - 1);
    }

    public void removeElementAndUpdate(int index)
    {
        removeElementAt(index);
        fireContentsChanged(this, 0, getSize() - 1);
    }
}