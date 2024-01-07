import java.sql.*;
import java.util.Scanner;

public class StudentUpdate {

    public static void main(String[] args) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/school_db";
        String USERNAME = "root";
        String PASSWORD = "";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the student ID to update: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter new details for the student (press Enter to skip a column update):");

            System.out.print("Enter name: ");
            String name = readLineOrSkip(scanner);

            System.out.print("Enter USN: ");
            String usn = readLineOrSkip(scanner);

            System.out.print("Enter semester: ");
            String semesterStr = readLineOrSkip(scanner);
            int semester = (semesterStr.isEmpty()) ? -1 : Integer.parseInt(semesterStr);

            System.out.print("Enter age: ");
            String ageStr = readLineOrSkip(scanner);
            int age = (ageStr.isEmpty()) ? -1 : Integer.parseInt(ageStr);

            System.out.print("Enter course: ");
            String course = readLineOrSkip(scanner);

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dob = readLineOrSkip(scanner);

            System.out.print("Enter address: ");
            String address = readLineOrSkip(scanner);

            // Construct the update query based on the provided values
            String query = "UPDATE students SET ";
            if (!name.isEmpty())
                query += "name='" + name + "', ";
            if (!usn.isEmpty())
                query += "usn='" + usn + "', ";
            if (semester != -1)
                query += "semester=" + semester + ", ";
            if (age != -1)
                query += "age=" + age + ", ";
            if (!course.isEmpty())
                query += "course='" + course + "', ";
            if (!dob.isEmpty())
                query += "dob='" + dob + "', ";
            if (!address.isEmpty())
                query += "address='" + address + "', ";

            // Remove the trailing comma and space
            query = query.substring(0, query.length() - 2);

            // Add the WHERE clause to specify the student ID
            query += " WHERE id=" + studentId;

            try (Statement statement = connection.createStatement()) {
                int rowsUpdated = statement.executeUpdate(query);

                if (rowsUpdated > 0) {
                    System.out.println("Data updated successfully!");
                } else {
                    System.out.println("No student found with the provided ID.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readLineOrSkip(Scanner scanner) {
        String input = scanner.nextLine().trim();
        return (input.equalsIgnoreCase("skip")) ? "" : input;
    }
}
