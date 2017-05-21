package launch;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public int getId_userforSearch(int Id_user){return Id_user;}
    public static void CREATE_TABLE_UserTrainigs() {
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
    public int Add_DanUserTrainings(int AmountOfMinutes, int NumberOfCaloriesBurned,  int Id_training,int Id_user) {
        int result = 0;
        Connection c = null;
        PreparedStatement stmt = null;
        boolean cout = false;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");

            stmt = c.prepareStatement("INSERT INTO UserTrainings VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            stmt.setInt(2, AmountOfMinutes);
            stmt.setInt(3,NumberOfCaloriesBurned);
            stmt.setInt(4,Id_training);
            stmt.setInt(5,Id_user);
            stmt.execute();

            return 50;
        } catch (Exception var12) {
            System.err.println(var12.getClass().getName() + ": " + var12.getMessage());
            System.exit(0);
        }

        throw new IllegalStateException("Такого быть не должно");
    }
    public static ResultSet resSet;
    public List<BD_UserTrainings> Look_UserTrainings(int Id_user) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM UserTrainings WHERE  Id_user ="+this.getId_userforSearch(Id_user));
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_UserTrainings adm = new BD_UserTrainings();
                adm.setData(resSet.getDate("Date"));
                adm.setAmountOfMinute(resSet.getInt("AmountOfMinutes"));
                adm.setNumbersOfCaloriesBurned(resSet.getInt("NumbersOfCaloriesBurned"));
                adm.setId_training(resSet.getInt("Id_training"));
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
