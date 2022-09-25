package first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    private static final Scanner scanner = new Scanner(System.in);

    public static void upd(Connection connection) throws SQLException {
        System.out.println("################ Account Update ########################\n");
        System.out.println("Select the data you want to update :\n");
        System.out.println("1.Username update");
        System.out.println("2.Password update");
        System.out.println("3.Email update");
        System.out.println("4.Phone update");
        System.out.println("5.Return to main menu");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Option:");
        int n = myObj.nextInt();
        switch (n){
            case 1:
                System.out.println("--------Username update wizard---------");
                String sql = "update banking_details set username = ? where username = ? ";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                System.out.println("Enter username");
                preparedStatement.setString(2, scanner.nextLine());

                System.out.println("Enter username to update");
                preparedStatement.setString(1, scanner.nextLine());

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
                System.out.println("--------Password update wizard----------");
                String sql2 = "update banking_details set password = ? where username = ? ";

                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

                System.out.println("Enter username");
                preparedStatement2.setString(2, scanner.nextLine());

                System.out.println("Enter password to update..");
                preparedStatement2.setString(1, scanner.nextLine());

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
                System.out.println("------------Email update-----------");
                String sql3 = "update banking_details set email = ? where username = ? ";

                PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);

                System.out.println("Enter username");
                preparedStatement3.setString(2, scanner.nextLine());

                System.out.println("Enter email to update..");
                preparedStatement3.setString(1, scanner.nextLine());

                int rows3 = preparedStatement3.executeUpdate();

                if (rows3 > 0 ) {
                    System.out.println("Account updated successfully. Please login to start booking.");
                    System.out.println('\n');
                    MyJDBC.menu();

                }else {
                    System.out.println("Something went wrong. Try again later.");
                    MyJDBC.menu();
                }
            case 4:
                System.out.println("-------------Phone update wizard--------------");
                String sql4 = "update banking_details set phone = ? where username = ? ";

                PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);

                System.out.println("Enter username");
                preparedStatement4.setString(2, scanner.nextLine());

                System.out.println("Enter phone number to update..");
                preparedStatement4.setString(1, scanner.nextLine());

                int rows4 = preparedStatement4.executeUpdate();

                if (rows4 > 0 ) {
                    System.out.println("Account updated successfully. Please login to start booking.");
                    System.out.println('\n');
                    MyJDBC.menu();

                }else {
                    System.out.println("Something went wrong. Try again later.");
                    MyJDBC.menu();
                }
            case 5:
                MyJDBC.menu();
                break;
        }



    }
}
