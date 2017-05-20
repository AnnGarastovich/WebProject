package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

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

    public int getAmountOfDrinks() {
        return AmountOfDrinks;
    }

    public int getId_user() {
        return Id_user;
    }

    public void CREATE_TABLE_WaterBalance() {
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

}
