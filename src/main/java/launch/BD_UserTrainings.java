package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by Ann on 14.05.2017.
 */
public class BD_UserTrainings {
public  Date data;
public int AmountOfMinute;
public int NumbersOfCaloriesBurned;
public int Id_training;
public int Id_user;
public BD_UserTrainings (){}
 public BD_UserTrainings( Date data, int AmountOfMinute, int NumbersOfCaloriesBurned, int Id_training, int Id_user)
{this.data=data;
this.AmountOfMinute=AmountOfMinute;
this.NumbersOfCaloriesBurned=NumbersOfCaloriesBurned;
this.Id_training=Id_training;
this.Id_user=Id_user;
}
public void setData( Date data){this.data=data;}
public void setAmountOfMinute(int AmountOfMinute){this.AmountOfMinute=AmountOfMinute;}
public void setNumbersOfCaloriesBurned(int NumbersOfCaloriesBurned){this.NumbersOfCaloriesBurned=NumbersOfCaloriesBurned;}
public void setId_training (int Id_training){this.Id_training=Id_training;}
public void setId_user(int Id_user){this.Id_user=Id_user;}
public Date getData(){return data;}
public int getAmountOfMinute(){return AmountOfMinute;}
public int getNumbersOfCaloriesBurned(){return NumbersOfCaloriesBurned;}
public int getId_training(){return Id_training;}
public int getId_user(){return Id_user;}
    public void CREATE_TABLE_UserTrainigs() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE UserTrainings " +
                    "(Date DATETIME PRIMARY KEY  NOT NULL," +
                    "AmountOfMinutes INT NOT NULL,"+
                    " NumbersOfCaloriesBurned   INT NOT NULL,"+
                    "Id_training INT NOT NULL,"+
                    "Id_user INT NOT NULL,"+
                    "CONSTRAINT FK_idtraining FOREIGN KEY (Id_training) REFERENCES ListOfTraining (Id_training) ON UPDATE CASCADE,"+
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
