package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Ann on 14.05.2017.
 */
public class BD_ListOfFood {
    public  int Id_Food;
    public String Name;
    public int AmountOfCaloriesIn100gr;
    public BD_ListOfFood(){}
    public BD_ListOfFood(int Id_Food, String Name,int AmountOfCaloriesIn100gr)
    {
        this.Id_Food=Id_Food;
        this.Name=Name;
        this.AmountOfCaloriesIn100gr=AmountOfCaloriesIn100gr;
    }
    public void CREATE_TABLE_ListOfFood() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE ListOfFood" +
                    "(Id_food  INT IDENTITY(1,1) PRIMARY KEY  NOT NULL," +
                    " Name        TEXT    NOT NULL," +
                    "AmountOfCaloriesIn100gr INT NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

}
