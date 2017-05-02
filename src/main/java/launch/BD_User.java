package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 01.05.2017.
 */
public class BD_User {
    public int id_user;
    public String name;
    public String login;
    public String password;
    public int weight;
    public int height;
    public int age;

    public void sedIdUser(int id_user) {
        this.id_user = id_user;
    }

    public void sedName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sedLogin(String login) {
        this.login = login;
    }

    public void sedPassword(String password) {
        this.password = password;
    }

    public void sedWeight(int weight) {
        this.weight = weight;
    }

    public void sedHeight(int height) {
        this.height = height;
    }

    public void sedAge(int age) {
        this.age = age;
    }

    public void InsertDan() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO User " +
                    "VALUES ( 1,'Анна','anngarastovich', '2774357a', 170, 80,20);";
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

    public List<BD_User> Look_User() {
        Connection c = null;
        int y = 0;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            int counter = 0;
            List<BD_User> adminlist = new ArrayList();
            System.out.println("fff");
            resSet = stmt.executeQuery("SELECT * FROM User;");
            System.out.println("FF");
            while (resSet.next()) {
                System.out.println("GG");
                BD_User adm = new BD_User();
                adm.sedIdUser(resSet.getInt("Id_user"));
                adm.sedName(resSet.getString("Name"));
                adm.sedLogin(resSet.getString("Login"));
                adm.sedPassword(resSet.getString("Password"));
                adm.sedWeight(resSet.getInt("Weight"));
                adm.sedHeight(resSet.getInt("Height"));
                adm.sedAge(resSet.getInt("Age"));
                adminlist.add(adm);
            }
            resSet.close();
            stmt.close();
            c.close();

            return adminlist;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        throw new IllegalStateException("Такого быть не должно");


    }

    public void CREATE_TABLE_User() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ZOJ.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE User " +
                    "(Id_user INT  PRIMARY KEY  NOT NULL," +
                    " Name        TEXT    NOT NULL," +
                    "Login TEXT NOT NULL, " +
                    "Password   TEXT NOT NULL," +
                    "Height INT ," + " Weight INT," + "Age INT) ";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    @Override
    public String toString() {
        return "BD_User{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
