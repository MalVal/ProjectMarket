package Model.ModelComboBox;

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

    public void update(ArrayList<E> items)
    {
        removeAllElements();
        for (E item : items)
        {
            addElement(item);
        }
        fireContentsChanged(this, 0, getSize() - 1);
    }
}