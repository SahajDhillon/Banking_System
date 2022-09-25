package first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    private static final Scanner scanner = new Scanner(System.in);

    public static void del(Connection connection) throws SQLException {
        System.out.println("----------------DELETING WIZARD--------------");

        String sql = "delete from users where username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Enter username you want to delete");
        preparedStatement.setString(1, scanner.nextLine());

        int rows = preparedStatement.executeUpdate();

        if (rows > 0 ) {
            System.out.println("Account Deleted successfully.");
            System.out.println('\n');
            MyJDBC.menu();

        }else {
            System.out.println("Something went wrong. Try again later.");
            MyJDBC.menu();
        }

    }
}
