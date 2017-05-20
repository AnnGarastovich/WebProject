package launch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ann on 20.05.2017.
 */
public class BD_connection {
    private static final BD_connection Con = new BD_connection();
    private BD_connection(){}
    public Connection Connection() throws ClassNotFoundException, SQLException {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:ZOJ3.db");
//            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            return c;
    }

    public static  BD_connection Ret (){return Con;}
}
