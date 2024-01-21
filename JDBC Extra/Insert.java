import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/school_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the number of students: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("Enter details for student " + i + ":");

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter USN: ");
                String usn = scanner.nextLine();

                System.out.print("Enter semester: ");
                int semester = scanner.nextInt();

                System.out.print("Enter age: ");
                int age = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Enter course: ");
                String course = scanner.nextLine();

                System.out.print("Enter date of birth (YYYY-MM-DD): ");
                String dob = scanner.nextLine();

                System.out.print("Enter address: ");
                String address = scanner.nextLine();

                String query = "INSERT INTO students (name, usn, semester, age, course, dob, address) VALUES('" + name
                        + "', '" + usn + "', '" + semester + "', '" + age
                        + "', '" + course + "', '" + dob + "', '" + address + "')";

                Statement statement = connection.createStatement();
                statement.executeUpdate(query);

                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
