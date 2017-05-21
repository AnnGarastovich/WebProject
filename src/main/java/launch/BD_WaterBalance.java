package launch;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ann on 08.05.2017.
 */
public class BD_WaterBalance {
    public Date data;
    public int AmountOfDrinks;
    public int Id_user;

 public   BD_WaterBalance() {}

    BD_WaterBalance(Date data, int AmountOfDrinks, int Id_user) {
        this.data = data;
        this.AmountOfDrinks = AmountOfDrinks;
        this.Id_user = Id_user;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAmountOfDrinks(int AmountOfDrinks) {
        this.AmountOfDrinks = AmountOfDrinks;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public Date getData() {
        return data;
    }
    public String getDataforSearch(String data){return data;}

    public int getAmountOfDrinks() {
        return AmountOfDrinks;
    }

    public int getId_user() {
        return Id_user;
    }
    public int getId_userforSearch(int Id_user){return Id_user;}

    public static void CREATE_TABLE_WaterBalance() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE WaterBalance " +
                    "(Date DATETIME PRIMARY KEY  NOT NULL," +
                    " AmountOfDrinks   INT," +
                    "Id_user INT," +
                    "FOREIGN KEY (Id_user) REFERENCES User (Id_user) \n" +
                    "  ON UPDATE NO ACTION)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public int Add_DanWater(int AmountOfDrink, int Id_user) {
        int result = 0;
        Connection c = null;
        PreparedStatement stmt = null;
        boolean cout = false;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");
            stmt = c.prepareStatement("INSERT INTO WaterBalance VALUES (?, ?, ?)");
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            stmt.setInt(2, AmountOfDrink);
            stmt.setInt(3, Id_user);
            stmt.execute();

            return 50;
        } catch (Exception var12) {
            System.err.println(var12.getClass().getName() + ": " + var12.getMessage());
            System.exit(0);
        }

        throw new IllegalStateException("Такого быть не должно");
    }
    public static ResultSet resSet;
    public List<BD_WaterBalance> Look_WaterBalance( int Id_user) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM WaterBalance WHERE  Id_user ="+this.getId_userforSearch(Id_user));
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_WaterBalance adm = new BD_WaterBalance();
                adm.setData(resSet.getDate("Date"));
                adm.setAmountOfDrinks(resSet.getInt("AmountOfDrinks"));
                adm.setId_user(resSet.getInt("Id_user"));
                adminlist.add(adm);
            }

            resSet.close();
            stmt.close();
            c.close();
            return adminlist;
        } catch (Exception var8) {
            System.err.println(var8.getClass().getName() + ": " + var8.getMessage());
            System.exit(0);
            System.out.println("Operation done successfully");
            throw new IllegalStateException("Такого быть не должно");
        }
    }

}
