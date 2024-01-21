import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/school_db";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String query = "SELECT * FROM students";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String usn = resultSet.getString("usn");
                int semester = resultSet.getInt("semester");
                int age = resultSet.getInt("age");
                String course = resultSet.getString("course");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");

                System.out.println("Name: " + name + " USN: " + usn + " Semester: " + semester + " Age: " + age
                        + " Course: " + course + " DOB: " + dob + " Address: " + address);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
