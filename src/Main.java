import Model.MainData;
import View.MainWindow;

public class Main
{
    public static void main(String[] args)
    {
        MainWindow mw =  new MainWindow(new MainData());
        mw.setVisible(true);
    }
}