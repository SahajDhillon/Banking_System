package first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Balance {
    private static final Scanner scanner = new Scanner(System.in);

    public static void bal(Connection connection) throws SQLException {
        System.out.println("################ Welcome ########################\n");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Option:");
        int n = myObj.nextInt();
        switch (n){
            case 1:
                System.out.println("--------Deposit amount---------");
                String sql = "update banking_details set balance = balance + ? where username = ? ";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                System.out.println("Enter amount");
                preparedStatement.setString(1, scanner.nextLine());

                System.out.println("Enter username to update");
                preparedStatement.setString(2, scanner.nextLine());

                int rows = preparedStatement.executeUpdate();

                if (rows > 0 ) {
                    System.out.println("Account updated successfully. Please login to start booking.");
                    System.out.println('\n');
                    MyJDBC.menu();

                }else {
                    System.out.println("Something went wrong. Try again later.");
                    MyJDBC.menu();
                }
            case 2:
                System.out.println("--------Withdraw amount---------");
                String sql2 = "update banking_details set balance = balance + ? where username = ? ";

                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

                System.out.println("Enter amount");
                preparedStatement2.setString(1, scanner.nextLine());

                System.out.println("Enter username to update");
                preparedStatement2.setString(2, scanner.nextLine());

                int rows2 = preparedStatement2.executeUpdate();

                if (rows2 > 0 ) {
                    System.out.println("Account updated successfully. Please login to start booking.");
                    System.out.println('\n');
                    MyJDBC.menu();

                }else {
                    System.out.println("Something went wrong. Try again later.");
                    MyJDBC.menu();
                }
            case 3:
                MyJDBC.menu();
                break;
        }



    }
}

