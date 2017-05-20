package launch;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 14.05.2017.
 */
public class BD_ListOfTrainings {
    public int Id_training;
    public String Name;
    public int AmountOfCaloriesBurnedIn10min;
    public BD_ListOfTrainings(){}
    public void setId_training(int Id_training)
    {
        this.Id_training=Id_training;
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public void setAmountOfCaloriesBurnedIn10min(int AmountOfCaloriesBurnedIn10min)
    {
        this.AmountOfCaloriesBurnedIn10min=AmountOfCaloriesBurnedIn10min;
    }
    public int getId_trainig(){return Id_training;}
    public String getNameforSearch(String name){return Name;}
    public String getName(){return Name;}
    public int getAmountOfCaloriesBurnedIn10min(){return AmountOfCaloriesBurnedIn10min;}
    BD_ListOfTrainings(int Id_training, String Name, int AmountOfCaloriesBurned10min)
    {
        this.Id_training= Id_training;
        this.Name=Name;
        this.AmountOfCaloriesBurnedIn10min=AmountOfCaloriesBurned10min;
    }
    public void CREATE_TABLE_ListOfTrainigs() {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            String sql = "CREATE TABLE ListOfTrainings" +
                    "(Id_trainig  INTEGER  PRIMARY KEY AUTOINCREMENT," +
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
    public void InsertDanListOfTraining() {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            String sql = "INSERT INTO ListOfTrainings " +
                    "VALUES ( 1,'Joggin',110);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static ResultSet resSet;
    public List<BD_ListOfTrainings> Look_ListOfTrainings() {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            int counter = 0;
            List<BD_ListOfTrainings> traininglist= new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM ListOfTrainings;");
            System.out.println("FF");
            while (resSet.next()) {
                System.out.println("GG");
                BD_ListOfTrainings adm = new BD_ListOfTrainings();
                adm.setId_training(resSet.getInt("Id_trainig"));
                adm.setName(resSet.getString("Name"));
                adm.setAmountOfCaloriesBurnedIn10min(resSet.getInt("AmountOfCaloriesBurned10min"));

                traininglist.add(adm);
            }
            resSet.close();
            stmt.close();
            c.close();

            return traininglist;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        throw new IllegalStateException("Такого быть не должно");


    }
    public List<BD_ListOfTrainings> Search_Training(String name) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM ListOfTrainings WHERE Name =" + this.getNameforSearch(name));
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_ListOfTrainings adm = new BD_ListOfTrainings();
                adm.setId_training(resSet.getInt("Id_training"));
                adm.setName(resSet.getString("Name"));
                adm.setAmountOfCaloriesBurnedIn10min(resSet.getInt("AmountOfCaloriesBurnedIn10min"));
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
    public int Add_DanListOfTrainings( String Name,  int AmountOfCaloriesBurnedIn10min) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            int result=0;
            String e = "INSERT INTO ListOfTrainings (Name, AmountOfCaloriesBurned10min) VALUES("  + "\'" + Name+ "\'" + "," + AmountOfCaloriesBurnedIn10min + ')';
            int i = stmt.executeUpdate(e);
            if(i == 1) {
                result=50;
                return result;
            }
        } catch (Exception var12) {
            System.err.println(var12.getClass().getName() + ": " + var12.getMessage());
            System.exit(0);
        }

        throw new IllegalStateException("Такого быть не должно");
    }
}
