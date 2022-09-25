package first;

import java.sql.*;

import java.util.Scanner;

public class Registration {
    private static final Scanner scanner = new Scanner(System.in);

    public static void signUp(Connection connection) throws SQLException {
        System.out.println("Welcome, Make an account !!");

        String sql = "insert into banking_details(username, password , email , phone) values (?,?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter username");
        preparedStatement.setString(1, scanner.nextLine());

        System.out.println("Enter password");
        preparedStatement.setString(2, scanner.nextLine());

        System.out.println("Enter email");
        preparedStatement.setString(3, scanner.nextLine());

        System.out.println("Enter phone");
        preparedStatement.setString(4, scanner.nextLine());

        int rows = preparedStatement.executeUpdate();

        if (rows > 0 ) {
            System.out.println("Account made successfully.");
            System.out.println('\n');
            MyJDBC.menu();

        }else {
            System.out.println("Something went wrong. Try again later.");
            MyJDBC.menu();
        }

    }
}
