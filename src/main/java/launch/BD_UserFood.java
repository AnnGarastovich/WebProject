package launch;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void setData(Date data){this.data=data;}
    public void setQuantityEatenGr(int QuantityEatenGr){this.QuantityEatenGr=QuantityEatenGr;}
    public void setNumberOfCalories(int NumberOfCalories){this.NumberOfCalories=NumberOfCalories;}
    public void setId_food(int Id_food){this.Id_food=Id_food;}
    public void setId_user(int Id_user){this.Id_user=Id_user;}
    public Date getData(){return data;}
    public int getQuantityEatenGr(){return QuantityEatenGr;}
public int getNumberOfCalories(){return NumberOfCalories;}
public int getId_food(){return Id_food;}
public int getId_user(){return Id_user;}
public int getId_userforSearch(int Id_user){return Id_user;}
    public static void CREATE_TABLE_UserFood() {
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
    public int Add_DanUserFood(int QuantityEatenGr, int NumberOfCalories,  int Id_food,int Id_user) {
        int result = 0;
        Connection c = null;
        PreparedStatement stmt = null;
        boolean cout = false;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
            System.out.println("Opened database successfully");

            stmt = c.prepareStatement("INSERT INTO UserFood VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            stmt.setInt(2, QuantityEatenGr);
            stmt.setInt(3,NumberOfCalories);
            stmt.setInt(4,Id_food);
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
    public List<BD_UserFood> Look_UserFood( int Id_user) {
        Statement stmt = null;
        Connection c = null;
        try {
            c= BD_connection.Ret().Connection();
            stmt=c.createStatement();
            boolean e = false;
            ArrayList adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM UserFood WHERE  Id_user ="+this.getId_userforSearch(Id_user));
            System.out.println("FF");

            while(resSet.next()) {
                System.out.println("GG");
                BD_UserFood adm = new BD_UserFood();
                adm.setData(resSet.getDate("Date"));
                adm.setQuantityEatenGr(resSet.getInt("QuantityEatengr"));
                adm.setNumberOfCalories(resSet.getInt("NumbersOfCalories"));
                adm.setId_food(resSet.getInt("Id_food"));
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
