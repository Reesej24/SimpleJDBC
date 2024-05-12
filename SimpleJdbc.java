import java.util.Scanner;
import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded.");

        // Establish a connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/Miramar", "testuser", "Pa$$word");
        System.out.println("Database connected.");

        // Create a statement
        Statement statement = connection.createStatement();
        System.out.println("Enter table values: ");

        // Execute a statement
        Scanner scnr = new Scanner(System.in);
        statement.executeUpdate(scnr.nextLine());
        System.out.println("Table updated!");
        System.out.println();
        System.out.println("Enter SQL Query: ");

        // Execute a statement
        ResultSet resultSet = statement.executeQuery(scnr.nextLine());

        // Iterate through the result and print the student names
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" +
                    resultSet.getString(4) + "\t" + resultSet.getString(5) + "\t" +
                    resultSet.getString(6) + "\t" + resultSet.getString(7) + "\t" +
                    resultSet.getString(8) + "\t" + resultSet.getString(9));
        }

        // Close the connection
        connection.close();
    }
}
