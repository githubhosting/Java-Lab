import java.sql.*;

public class lab10 {

  // JDBC URL, username, and password of MySQL server
  private static final String JDBC_URL =
    "jdbc:mysql://localhost:3306/school_db";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "";

  public static void main(String[] args) {
    // Step 1: Establishing a Connection
    try (
      Connection connection = DriverManager.getConnection(
        JDBC_URL,
        DB_USER,
        DB_PASSWORD
      )
    ) {
      // Step 2: Creating a Statement
      Statement statement = connection.createStatement();

      // Step 3: CRUD Operations

      // CREATE operation
      String createQuery =
        "INSERT INTO students (id, name, usn, semester, age, course, dob, address) VALUES (17, 'random', 21, 3, 15, 'Computer Science', '2003-05-07', '221b baker street')";
      statement.executeUpdate(createQuery);
      System.out.println("Record created successfully.");

      // READ operation
      String readQuery = "SELECT * FROM students";
      ResultSet resultSet = statement.executeQuery(readQuery);
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
      }

      // UPDATE operation
      String updateQuery = "UPDATE students SET age = 22 WHERE name = 'John'";
      statement.executeUpdate(updateQuery);
      System.out.println("Record updated successfully.");

      // DELETE operation
      String deleteQuery = "DELETE FROM students WHERE name = 'John'";
      statement.executeUpdate(deleteQuery);
      System.out.println("Record deleted successfully.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
