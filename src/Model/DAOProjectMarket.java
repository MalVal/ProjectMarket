package Model;

import Model.Entity.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class DAOProjectMarket implements DataAccessLayer, Serializable
{

    private transient String darkTheme;
    private static final String DEFAULT_SAVE_PATH = "." + File.separator + "data" + File.separator + "SaveProjectMarket.pm";
    private static final String DEFAULT_PROPERTIES_PATH = "." + File.separator + "config" + File.separator + "config.properties";
    private final transient File saveFile;
    private transient final CurrentClient currentClient;
    private ArrayList<ArticleType> listArticleType;
    private ArrayList<Article> listArticle;
    private ArrayList<Provider> listProvider;
    private ArrayList<Purchase> listPurchase;
    private ArrayList<Client> listClient;
    private ArrayList<Employee> listEmployee;

    public DAOProjectMarket()
    {

        this.saveFile = new File(DEFAULT_SAVE_PATH);
        this.currentClient = new CurrentClient();
        if(!this.load())
        {
            listArticleType = new ArrayList<>();
            listArticle = new ArrayList<>();
            listProvider = new ArrayList<>();
            listPurchase = new ArrayList<>();
            listClient = new ArrayList<>();
            listEmployee = new ArrayList<>();
            this.addEmployee(new Employee("admin", "---", "---", LocalDate.parse("2004-09-11"), "admin", 0));
        }

        Properties prop = new Properties();
        File file = new File(DEFAULT_PROPERTIES_PATH);
        try
        {
            if (!file.exists())
            {
                file.getParentFile().mkdirs();
                file.createNewFile();
                prop.setProperty("DarkTheme", "false");
                darkTheme = "false";
                FileOutputStream output = new FileOutputStream(file.getAbsolutePath());
                prop.store(output, "configuration");
                output.close();
            }
            else
            {
                try (FileInputStream input = new FileInputStream(file))
                {
                    prop.load(input);
                    darkTheme = prop.getProperty("DarkTheme");
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public DAOProjectMarket(File saveFile)
    {
        this.saveFile = saveFile;
        this.currentClient = new CurrentClient();
        if(!this.load())
        {
            listArticleType = new ArrayList<>();
            listArticle = new ArrayList<>();
            listProvider = new ArrayList<>();
            listPurchase = new ArrayList<>();
            listClient = new ArrayList<>();
            listEmployee = new ArrayList<>();
            this.addEmployee(new Employee("admin", "---", "---", LocalDate.parse("2004-09-11"), "admin", 0));
        }

        Properties prop = new Properties();
        File file = new File(DEFAULT_PROPERTIES_PATH);
        try
        {
            if (!file.exists())
            {
                file.getParentFile().mkdirs();
                file.createNewFile();
                prop.setProperty("DarkTheme", "false");
                darkTheme = "false";
                FileOutputStream output = new FileOutputStream(file.getAbsolutePath());
                prop.store(output, "configuration");
                output.close();
            }
            else
            {
                try (FileInputStream input = new FileInputStream(file))
                {
                    prop.load(input);
                    darkTheme = prop.getProperty("DarkTheme");
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addArticle(Article article) {
        if(article == null) return;

        for(Article a : listArticle)
        {
            if(a.equals(article))
            {
                int quantity1 = a.getQuantity();
                int quantity2 = article.getQuantity();
                int newQuantity = quantity1 + quantity2;
                a.setQuantity(newQuantity);
                return;
            }
        }
        listArticle.add(article);
        this.save();
    }

    @Override
    public boolean addArticleType(ArticleType articleType) {
        if(articleType == null) return false;

        for(ArticleType at : listArticleType)
        {
            if(at.equals(articleType))
            {
                return false;
            }
        }

        listArticleType.add(articleType);
        this.save();
        return true;
    }

    @Override
    public boolean addClient(Client client) {
        if(client == null) return false;

        for(Client c : listClient)
        {
            if(c.equals(client))
            {
                return false;
            }
        }

        listClient.add(client);
        this.save();
        return true;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(employee == null) return false;

        for(Employee e : listEmployee)
        {
            if(e.equals(employee))
            {
                return false;
            }
        }

        listEmployee.add(employee);
        this.save();
        return true;
    }

    @Override
    public boolean addProvider(Provider provider) {
        if(provider == null) return false;

        for(Provider p : listProvider)
        {
            if(p.equals(provider))
            {
                return false;
            }
        }

        listProvider.add(provider);
        this.save();
        return true;
    }

    @Override
    public void addPurchase(Purchase purchase) {
        if(purchase == null) return;
        listPurchase.add(purchase);
        this.save();
    }

    @Override
    public void deleteArticle(Article article) {
        listArticle.remove(article);
        this.save();
    }

    @Override
    public void deleteArticleType(ArticleType articleType) {
        listArticleType.remove(articleType);
        this.save();
    }

    @Override
    public void deleteClient(Client client) {
        listClient.remove(client);
        this.save();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        listEmployee.remove(employee);
        this.save();
    }

    @Override
    public void deleteProvider(Provider provider) {
        listProvider.remove(provider);
        this.save();
    }

    @Override
    public void ModifyArticleType(ArticleType oldArticleType, ArticleType newArticleType) {
        for (int i = 0; i < listArticleType.size(); i++)
        {
            if (listArticleType.get(i).equals(oldArticleType))
            {
                listArticleType.set(i, newArticleType);
                this.save();
                return;
            }
        }
    }

    @Override
    public void ModifyClient(Client oldClient, Client newClient) {
        for (int i = 0; i < listClient.size(); i++)
        {
            if (listClient.get(i).equals(oldClient))
            {
                listClient.set(i, newClient);
                this.save();
                return;
            }
        }
    }

    @Override
    public void ModifyEmployee(Employee oldEmployee, Employee newEmployee) {
        for (int i = 0; i < listEmployee.size(); i++)
        {
            if (listEmployee.get(i).equals(oldEmployee))
            {
                listEmployee.set(i, newEmployee);
                this.save();
                return;
            }
        }
    }

    @Override
    public void ModifyProvider(Provider oldProvider, Provider newProvider) {
        for (int i = 0; i < listProvider.size(); i++)
        {
            if (listProvider.get(i).equals(oldProvider))
            {
                listProvider.set(i, newProvider);
                this.save();
                return;
            }
        }
    }

    @Override
    public void decreaseQuantity(Article article) {
        for(Article a : listArticle)
        {
            if(a.equals(article))
            {
                if(a.getQuantity() - article.getQuantity() < 0)
                {
                    return;
                }
                else
                {
                    a.setQuantity(a.getQuantity() - article.getQuantity());
                    this.save();
                    return;
                }
            }
        }
    }

    @Override
    public Client searchClient(String registrationNumber) {

        for(Client c : listClient)
        {
            if(c.getRegistrationNumber().equals(registrationNumber))
            {
                return c.clone();
            }
        }

        return null;
    }

    @Override
    public Employee searchEmployee(String registrationNumber) {

        for(Employee e : listEmployee)
        {
            if(e.getRegistrationNumber().equals(registrationNumber))
            {
                return e.clone();
            }
        }

        return null;
    }

    @Override
    public boolean checkClientPassword(String registrationNumber, String password) {
        for(Client c : listClient)
        {
            if(c.getRegistrationNumber().equals(registrationNumber))
            {
                return c.getPassword().equals(password);
            }
        }
        return false;
    }

    @Override
    public boolean checkEmployeePassword(String registrationNumber, String password) {
        for(Employee e : listEmployee)
        {
            if(e.getRegistrationNumber().equals(registrationNumber))
            {
                return e.getPassword().equals(password);
            }
        }
        return false;
    }

    @Override
    public void setCurrentClient(Client client) {

        ArrayList<Purchase> purchases = new ArrayList<>();

        for(Purchase p : listPurchase)
        {
            if(p.getBuyer().equals(client))
            {
                purchases.add(p);
            }
        }

        this.currentClient.setClient(client);
        this.currentClient.setPurchases(purchases);
    }

    @Override
    public CurrentClient getCurrentClient() {
        return this.currentClient;
    }

    @Override
    public void addToBasket(Article article) {
        this.currentClient.getBasket().addArticle(article);
    }

    @Override
    public void removeToBasket(Article article) {
        this.currentClient.getBasket().removeArticle(article);
    }

    @Override
    public ArrayList<Article> getListArticle() {
        ArrayList<Article> copy = new ArrayList<>();
        for (Article a:listArticle) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<ArticleType> getListArticleType() {
        ArrayList<ArticleType> copy = new ArrayList<>();
        for (ArticleType a:listArticleType) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Client> getListClient() {
        ArrayList<Client> copy = new ArrayList<>();
        for (Client a:listClient) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Employee> getListEmployee() {
        ArrayList<Employee> copy = new ArrayList<>();
        for (Employee a:listEmployee) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Provider> getListProvider() {
        ArrayList<Provider> copy = new ArrayList<>();
        for (Provider a:listProvider) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public ArrayList<Purchase> getListPurchase() {
        ArrayList<Purchase> copy = new ArrayList<>();
        for (Purchase a:listPurchase) {
            copy.add(a.clone());
        }
        return copy;
    }

    @Override
    public void exportArticleType(ArticleType articleType, File file) {
        FileWriter fw;
        try
        {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(articleType.getName());
            bw.newLine(); // pour aller a la ligne
            bw.write(articleType.getCategory());
            bw.newLine();
            bw.write(Double.toString(articleType.getPrice()));
            bw.newLine();
            bw.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean importArticleType(File file) {
        FileReader fr;
        try
        {
            String name, category;
            double price;

            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            name = br.readLine();
            category = br.readLine();
            price = Double.parseDouble(br.readLine());

            ArticleType articleType = new ArticleType(name, category, price);

            return this.addArticleType(articleType);
        }
        catch (IOException e)
        {
            return false;
        }
    }

    public void save()
    {
        try
        {
            if (!saveFile.exists())
            {
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile.getAbsolutePath()));
            out.writeObject(this);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public boolean load()
    {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(saveFile.getAbsolutePath()));
            DAOProjectMarket loadedObject = (DAOProjectMarket) in.readObject();
            this.listArticleType = loadedObject.listArticleType;
            this.listArticle = loadedObject.listArticle;
            this.listProvider = loadedObject.listProvider;
            this.listPurchase = loadedObject.listPurchase;
            this.listClient = loadedObject.listClient;
            this.listEmployee = loadedObject.listEmployee;
            in.close();
            return true;
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String getDarkTheme()
    {
        return darkTheme;
    }

    public void setDarkTheme(String value)
    {
        Properties prop = new Properties();
        darkTheme = value;
        File file = new File(DEFAULT_PROPERTIES_PATH);
        prop.setProperty("DarkTheme", value);
        try
        {
            FileOutputStream output = new FileOutputStream(file.getAbsolutePath());
            prop.store(output, "configuration");
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
