package Controler;

import java.awt.event.*;

public class GestWindow extends WindowAdapter
{
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
