package first;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    private static final Scanner scanner = new Scanner(System.in);
    public static void login(Connection connection) throws SQLException {


        System.out.println("Welcome back, login to your account."+ '\n');
        String sql = "select * from banking_details where username = ?";

        //?(passing parameter) its value will be set by calling the setter methods of prepared statement.
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter username");
        preparedStatement.setString(1, scanner.nextLine());

        System.out.println("Enter your password");
        String password = scanner.nextLine();

        ResultSet result = preparedStatement.executeQuery();

        if (result.next()) {
            String correctPassword = result.getString("password");
            if ((correctPassword).equals(password)) {

                //After logging in..

                System.out.println("_____________\n");
                System.out.println("You are logged in");
                System.out.println("3: Update balance");
                System.out.println("4: view balance");
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice ==1){
                    Balance.bal(connection);
                }
                else if(choice==2){
                    viewBalance(connection);
                }




            } else {
                System.out.println("Invalid password");
                System.out.println("Try again");
                MyJDBC.menu();

            }

        } else {
            System.out.println("Sorry, username not found");
            System.out.println("Try Again");
            MyJDBC.menu();
        }
    }

    //Generate random String..
    static String getAlphaNumericString()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    // Ticket Booking System..
    public static void profile(Connection connection) throws SQLException {
        System.out.println("##########   Deposit amount  ##########");

        String sql = "insert into tickets(source, destination, passenger1, passenger2, passenger3, ticketNum) values (?,?,?,?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter amount");
        preparedStatement.setString(1, scanner.nextLine());

        System.out.println("Enter destination");
        preparedStatement.setString(2, scanner.nextLine());

        System.out.println("Enter passenger name:");
        preparedStatement.setString(3, scanner.nextLine());


        System.out.println("do you want to add another passenger y/n ?");
        Scanner myObj = new Scanner(System.in);
        String ans = myObj.nextLine();
        if(Objects.equals(ans, "y")){
            System.out.println("Enter passenger name:");
            preparedStatement.setString(4, scanner.nextLine());
        }else{
            preparedStatement.setNull(4, Types.NULL);
        }

        System.out.println("do you want to add another passenger y/n ?");
        Scanner myObj2 = new Scanner(System.in);
        String ans2 = myObj2.nextLine();
        if(Objects.equals(ans2, "y")){
            System.out.println("Enter passenger name:");
            preparedStatement.setString(5, scanner.nextLine());
        }else{
            preparedStatement.setNull(5, Types.NULL);
        }


        String ticketNum =getAlphaNumericString();
        preparedStatement.setString(6, ticketNum);

        int rows = preparedStatement.executeUpdate();

        if (rows > 0 ) {
            System.out.println("Your Ticket is booked successfully , Your ticket is " + ticketNum);
            System.out.println('\n');


        }else {
            System.out.println("Something went wrong. Try again later.");
        }
    }

    // Ticking Viewing System
    public static void viewBalance(Connection connection) throws SQLException{
        System.out.println("Welcome back, login to your account."+ '\n');
        String sql = "select balance from banking_details where id = ?";

        //?(passing parameter) its value will be set by calling the setter methods of prepared statement.
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter account_no.");
        preparedStatement.setString(1, scanner.nextLine());

        ResultSet result = preparedStatement.executeQuery();

        if (result.next()) {
            String balance = result.getString("balance");

                System.out.println("_____________\n");
                System.out.println("Your balance is:"+balance);
        } else {
            System.out.println("Sorry, acc no. not found");
            System.out.println("Try Again");
            MyJDBC.menu();
        }
    }
}