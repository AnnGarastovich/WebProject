package launch;

import java.sql.*;
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

    public BD_User() {
    }

    public BD_User(String login, String password) {
        this.login = login;
        this.password = password;
    }

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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static ResultSet getResSet() {
        return resSet;
    }

    public static void setResSet(ResultSet resSet) {
        BD_User.resSet = resSet;
    }

    public void InsertDan() {
        Statement stmt = null;
        Connection c = null;
        try {
            c = BD_connection.Ret().Connection();
            stmt = c.createStatement();
            String sql = "INSERT INTO User " +
                    "VALUES ( 'Анна','anngarastovich', '2774357a', 170, 80,20);";
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


    public List<BD_User> Look_User() {

        Statement stmt = null;
        try {

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

            return adminlist;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        throw new IllegalStateException("Такого быть не должно");


    }

    public static void CREATE_TABLE_User() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Connection c = null;
        try {
            c = BD_connection.Ret().Connection();
            stmt = c.createStatement();
            String sql = "CREATE TABLE User " +
                    "(Id_user INTEGER  PRIMARY KEY AUTOINCREMENT," +
                    " Name        TEXT    NOT NULL," +
                    "Login TEXT NOT NULL, " +
                    "Password   TEXT NOT NULL," +
                    "Height INT ," + " Weight INT," + "Age INT) ";

            stmt.execute(sql);
            stmt.close();
            c.close();
            System.out.println("Table created successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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

    public int Add_User(String name, String login, String password, int weight, int height, int age) {

        Statement stmt = null;
        Connection c = null;
        try {
            c = BD_connection.Ret().Connection();
            stmt = c.createStatement();
            int Result = 0;

            String e = "INSERT INTO User (Name, Login, Password, Height, Weight, Age)  VALUES(" + "\'" + name + "\'" + "," + "\'" + login + "\'" + "," + "\'" + password + "\'" + "," + height + "," + weight + "," + age + ')';
            int i = stmt.executeUpdate(e);
            if (i == 1) {
                Result = 1;
                return Result;
            }
        } catch (Exception var12) {
            System.err.println(var12.getClass().getName() + ": " + var12.getMessage());
            System.exit(0);
        }

        throw new IllegalStateException("Такого быть не должно");
    }

    public static ResultSet resSet;

    public int AVT(String User_login, String User_password) throws SQLException {
        Statement stmt = null;
        Connection c = null;
        try {
            c = BD_connection.Ret().Connection();
            stmt = c.createStatement();
            int result = 0;
            int cout = 0;
            resSet = stmt.executeQuery("SELECT Id_user, Login, Password FROM User ");
            while (resSet.next()) {
                id_user = resSet.getInt("Id_user");
                login = resSet.getString("Login");
                password = resSet.getString("Password");
                System.out.println(User_login);
                System.out.println(User_password);
                if (User_login.equals(login)) {
                    System.out.println("AAAAAA");
                    if (User_password.equals(password)) {


                        result = id_user;
                        cout++;
                        return result;

                    }
                }
            }
            if (cout == 0) {
                return result;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            stmt.close();
        }
        throw new IllegalStateException("Такого быть не должно");

    }
}
