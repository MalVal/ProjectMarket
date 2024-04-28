package View;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomDateFormat extends JFormattedTextField.AbstractFormatter
{
    @Override
    public Object stringToValue(String text) {
        return "";
    }

    @Override
    public String valueToString(Object value) {
        if(value != null)
        {
            Calendar cal = (Calendar) value;
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            return format.format(cal.getTime());
        }
        return "";
    }
}
