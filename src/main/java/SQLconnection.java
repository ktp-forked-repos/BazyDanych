import java.sql.*;

public class SQLconnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://DESKTOP-FBOH4FA\\SQLEXPRESS;databaseName=pierwszabazadanych;integratedSecurity=true;";

        Connection db = DriverManager.getConnection(url);
        System.out.println(db);

        Statement statement = db.createStatement();
        String sqlQuery = "Select * from Employees";
        ResultSet rs = statement.executeQuery(sqlQuery);

        while (rs.next()) {
//            System.out.println(rs.getDate("StartJobDate"));
            System.out.println(rs.getString("City"));
        }
        System.out.println("////////////////////");
        //insert
        String insert = "Insert INTO Employees (LastName, FirstName, Address, City, Salary, Age, StartJobDate, Benefit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = db.prepareStatement(insert);
        ps.setString(1, "Jarek");
        ps.setString(2, "Garek");
        ps.setString(3, "Bursztynowa");
        ps.setString(4, "Wilno");
        ps.setInt(5, 4500);
        ps.setInt(6, 42);
        ps.setDate(7, Date.valueOf("2018-10-15"));
        ps.setInt(8, 1);
        int rowInsert = ps.executeUpdate();
        if(rowInsert > 0) {
            System.out.println("Success!");
        }


    }
}
