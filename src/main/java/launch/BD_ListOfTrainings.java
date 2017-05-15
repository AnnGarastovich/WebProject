package launch;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Ann on 14.05.2017.
 */
public class BD_ListOfTrainings {
    public int Id_training;
    public String Name;
    public int AmountOfCaloriesBurnedIn10min;
    public BD_ListOfTrainings(){}
    BD_ListOfTrainings(int Id_training, String Name, int AmountOfCaloriesBurned10min)
    {
        this.Id_training= Id_training;
        this.Name=Name;
        this.AmountOfCaloriesBurnedIn10min=AmountOfCaloriesBurned10min;
    }
    public void CREATE_TABLE_ListOfTrainigs() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE ListOfTrainings" +
                    "(Id_trainig  INT IDENTITY(1,1) PRIMARY KEY  NOT NULL," +
                    " Name        TEXT    NOT NULL," +
                    "AmountOfCaloriesBurned10min INT NOT NULL)";

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
