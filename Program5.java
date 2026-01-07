package PracticeQ;

//Write a program to display records of all Students whose semester is 7 and branch is EC.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program5 {

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

            String selectQuery = "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = st.executeQuery(selectQuery);

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("studentId") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch") + " " +
                        rs.getDouble("marks") + " " +
                        rs.getInt("yearOfPassing") + " " +
                        rs.getInt("semester")
                );
            }

            if (!found) {
                System.out.println("No students found with semester 7 and branch EC");
            }

            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
