package PracticeQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

//Write a program to delete of all Students whose records whose year of passing is 2024. and branch is Civil.

public class Program4 {

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

            String deleteQuery = "DELETE FROM Students " +
                                 "WHERE branch = 'Civil' AND yearOfPassing = 2024";

            int rowsDeleted = st.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " record(s) deleted successfully");

            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}

