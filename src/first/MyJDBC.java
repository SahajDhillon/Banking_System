package first;

import java.sql.*;
import java.util.Scanner;

public class MyJDBC {
    private static Connection connection = null;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "password");
            System.out.println("Connected");
            menu();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void menu() throws SQLException {

        System.out.println("###########      BANKING SYSTEM      ##############");
        System.out.println("1: Sign up");
        System.out.println("2: Login");
        System.out.println("3: Update user");
        System.out.println("4: Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice ==1){
            Registration.signUp(connection);
        }
        else if(choice==2){
            Login.login(connection);
        }
        else if(choice ==3){
            Update.upd(connection);
        }
        else if (choice == 4) {
            System.exit(0);
        }
    }
}
