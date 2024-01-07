import java.sql.*;
import java.util.Scanner;

public class StudentDatabaseCRUD {

    public static void main(String[] args) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/school_db";
        String USERNAME = "root";
        String PASSWORD = "";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        addStudent(connection, scanner);
                        break;
                    case 2:
                        viewStudents(connection);
                        break;
                    case 3:
                        updateStudent(connection, scanner);
                        break;
                    case 4:
                        deleteStudent(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter details for the new student:");

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

        String query = String.format("INSERT INTO students (name, usn, semester, age, course, dob, address) " +
                "VALUES('%s', '%s', %d, %d, '%s', '%s', '%s')", name, usn, semester, age, course, dob, address);

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }

        System.out.println("Data inserted successfully!");
    }

    private static void viewStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM students";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("USN: " + resultSet.getString("usn"));
                System.out.println("Semester: " + resultSet.getInt("semester"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Date of Birth: " + resultSet.getString("dob"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println();
            }
        }
    }

    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter the student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new details for the student:");

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

        String query = String.format(
                "UPDATE students SET name='%s', usn='%s', semester=%d, age=%d, course='%s', dob='%s', address='%s' WHERE id=%d",
                name, usn, semester, age, course, dob, address, studentId);

        try (Statement statement = connection.createStatement()) {
            int rowsUpdated = statement.executeUpdate(query);

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("No student found with the provided ID.");
            }
        }
    }

    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter the student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        String query = String.format("DELETE FROM students WHERE id=%d", studentId);

        try (Statement statement = connection.createStatement()) {
            int rowsDeleted = statement.executeUpdate(query);

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with the provided ID.");
            }
        }
    }
}
