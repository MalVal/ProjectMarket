import Controller.Controller;
import Model.DAOProjectMarket;
import View.ViewProjectMarketSwing;

public class Main
{
    public static void main(String[] args)
    {
        Controller controller = new Controller(new DAOProjectMarket(), new ViewProjectMarketSwing());
        controller.run();
    }
}