package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by Ann on 18.05.2017.
 */
public class BD_UserFood {
    public Date data;
    public int QuantityEatenGr;
    public int NumberOfCalories;
    public int Id_food;
    public int Id_user;
    public BD_UserFood(){}
    public BD_UserFood(Date data, int QuantityEatenGr, int NumberOfCalories, int Id_food,int  Id_user)
    {
        this.data=data;
        this.QuantityEatenGr=QuantityEatenGr;
        this.NumberOfCalories=NumberOfCalories;
        this.Id_food=Id_food;
        this.Id_user=Id_user;
    }
    public void CREATE_TABLE_UserFood() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE UserFood " +
                    "(Date DATETIME PRIMARY KEY  NOT NULL," +
                    "QuantityEatengr INT NOT NULL,"+
                    " NumbersOfCalories   INT NOT NULL,"+
                    "Id_food INT NOT NULL,"+
                    "Id_user INT NOT NULL,"+
                    "CONSTRAINT FK_idfood FOREIGN KEY (Id_food) REFERENCES ListOfFood (Id_food) ON UPDATE CASCADE,"+
                    "CONSTRAINT FK_iduser FOREIGN KEY (Id_user) REFERENCES User (Id_user) ON UPDATE CASCADE)";


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
