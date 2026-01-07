package PracticeQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Program2 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/School",
                    "root",
                    "Root@123"
            );

            System.out.println("Connection Successful");

            Statement st = con.createStatement();

            String createTableQuery =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "eno INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "branch VARCHAR(30), " +
                    "percentage DOUBLE)";

            st.executeUpdate(createTableQuery);
            System.out.println("Students table created");

            String insertQuery =
                    "INSERT INTO Students VALUES " +
                    "(104, 'Rahul', 'CSE', 78.5), " +
                    "(105, 'Aman', 'IT', 82.0), " +
                    "(106, 'Neha', 'CSE', 90.3)";

            st.executeUpdate(insertQuery);
            System.out.println("Records inserted successfully");

            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
