import java.sql.*;

public class SQLconnection {
    private Connection connection;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://DESKTOP-FBOH4FA\\SQLEXPRESS;databaseName=pierwszabazadanych;integratedSecurity=true;";

        Connection db = DriverManager.getConnection(url);
        System.out.println(db);

        Statement statement = db.createStatement();
        String sqlQuery = "Select * from Employees";
        ResultSet rs = statement.executeQuery(sqlQuery);

/*        while (rs.next()) {
            System.out.println(rs.getDate("StartJobDate"));
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
            System.out.println("Success!");*/
    }

    public Connection connectionToSQLServer() {

        String url = "jdbc:sqlserver://DESKTOP-FBOH4FA\\SQLEXPRESS;databaseName=pierwszabazadanych;integratedSecurity=true;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            System.out.println(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void create(String LastName, String FirstName, String Adress, String City, int Salary, int Age, Date StartJobDate, int Benefit) throws ClassNotFoundException, SQLException {

        connection = connectionToSQLServer();

        String insert = "Insert INTO Employees (LastName, FirstName, Address, City, Salary, Age, StartJobDate, Benefit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, FirstName);
        ps.setString(2, LastName);
        ps.setString(3, Adress);
        ps.setString(4, City);
        ps.setInt(5, Salary);
        ps.setInt(6, Age);
        ps.setDate(7, StartJobDate);
        ps.setInt(8, Benefit);
        int rowInsert = ps.executeUpdate();
        if (rowInsert > 0) {
            System.out.println("Success!");
        }
    }


}
