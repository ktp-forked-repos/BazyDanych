import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://DESKTOP-FBOH4FA\\SQLEXPRESS;databaseName=pierwszabazadanych;integratedSecurity=true;";

        Connection db = DriverManager.getConnection(url);
        System.out.println(db);
    }
}
