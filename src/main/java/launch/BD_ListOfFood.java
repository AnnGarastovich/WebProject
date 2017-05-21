package launch;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 14.05.2017.
 */
public class BD_ListOfFood {
    public  int Id_Food;
    public String Name;
    public int AmountOfCaloriesIn100gr;
    public BD_ListOfFood(){}
    public BD_ListOfFood(int Id_Food, String Name,int AmountOfCaloriesIn100gr) {
        this.Id_Food = Id_Food;
        this.Name = Name;
        this.AmountOfCaloriesIn100gr = AmountOfCaloriesIn100gr;
    }
    public void setId_Food(int Id_Food)
    {
        this.Id_Food=Id_Food;
    }
    public void setName(String Name)
    {
        this.Name=Name;
    }
    public void setAmountOfCaloriesIn100gr(int AmountOfCaloriesIn100gr)
    {
        this.AmountOfCaloriesIn100gr=AmountOfCaloriesIn100gr;
    }
    public int getId_Food(){return Id_Food;}
    public String getNameforSearch(String name){return name;}
    public String getName(){return Name;}
    public int getAmountOfCaloriesIn100gr(){return AmountOfCaloriesIn100gr;}
    public static void CREATE_TABLE_ListOfFood() {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            String sql = "CREATE TABLE ListOfFood" +
                    "(Id_food  INTEGER  PRIMARY KEY AUTOINCREMENT," +
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
    public void InsertDanListOfFood() {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            String sql = "INSERT INTO ListOfFood " +
                    "VALUES ( 1,'Milk Chokolate',539);";
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
    public List<BD_ListOfFood> Look_ListOfFood() {
        Statement stmt = null;
        Connection c = null;
        try {
           c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            int counter = 0;
            List<BD_ListOfFood> listfood = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM ListOfFood;");
            System.out.println("FF");
            while (resSet.next()) {
                System.out.println("GG");
                BD_ListOfFood adm = new BD_ListOfFood();
                adm.setId_Food(resSet.getInt("Id_food"));
                adm.setName(resSet.getString("Name"));
                adm.setAmountOfCaloriesIn100gr(resSet.getInt("AmountOfCaloriesIn100gr"));

                listfood.add(adm);
            }
            resSet.close();
            stmt.close();
            c.close();

            return listfood;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        throw new IllegalStateException("Такого быть не должно");


    }
    public List<BD_ListOfFood> Search_Food(String name) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM ListOfFood WHERE Name =" + "'"+this.getNameforSearch(name)+"'");
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_ListOfFood adm = new BD_ListOfFood();
                adm.setId_Food(resSet.getInt("Id_food"));
                adm.setName(resSet.getString("Name"));
                adm.setAmountOfCaloriesIn100gr(resSet.getInt("AmountOfCaloriesIn100gr"));
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
    public int Add_DanListOfFood( String Name,  int AmountOfCaloriesIn100gr) {
      int result=0;

        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            String e = "INSERT INTO ListOfFood (Name, AmountOfCaloriesIn100gr) VALUES("  + "\'" + Name+ "\'" + "," + AmountOfCaloriesIn100gr + ')';
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

 /*   public int Search_Id_food(String name) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            int Id_food=0;
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM ListOfFood WHERE Name =" + "'"+BD_ListOfFood.getNameforSearch(name)+ "'");
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_ListOfTrainings adm = new BD_ListOfTrainings();
                Id_food=setId_food(resSet.getInt("Id_food"));
                adm.setName(resSet.getString("Name"));
                adm.setAmountOfCaloriesBurnedIn10min(resSet.getInt("AmountOfCaloriesBurned10min"));
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
    }*/
}
