package PracticeQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Program3 {

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

            String updateQuery =
                    "UPDATE Students " +
                    "SET percentage = percentage * 1.05 " +
                    "WHERE branch = 'CSE'";

            int rowsUpdated = st.executeUpdate(updateQuery);
            System.out.println(rowsUpdated + " record(s) updated successfully");

            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}

