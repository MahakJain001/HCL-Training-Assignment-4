package PracticeQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

//Write a program to create a table called Students using JDBC and insert records into it.

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
                    "branch VARCHAR(50), " +
                    "marks DOUBLE, " +
                    "yearOfPassing INT)";

            st.executeUpdate(createTableQuery);
            System.out.println("Students table created");

            String insertQuery =
            		 "INSERT INTO Students(name, branch, marks, yearOfPassing) VALUES " +
                             "('Rahul', 'CSE', 78.5, 2023), " +
                             "('Aman', 'Civil', 82.0, 2024), " +
                             "('Neha', 'Civil', 90.3, 2024)";

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
