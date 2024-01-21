import java.util.Scanner;

// Base class Person
class Person {

  String name;
  int age;
  char gender;

  // Method to read person details
  void readDetails() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = scanner.nextLine();
    System.out.print("Enter age: ");
    age = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.print("Enter gender (M/F/O): ");
    gender = scanner.next().charAt(0);
  }

  // Method to display person details
  void displayDetails() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
  }
}

// Derived class Employee extending Person
class Employee extends Person {

  String employeeId;

  // Method to read employee details
  void readEmployeeDetails() {
    readDetails();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Employee ID: ");
    employeeId = scanner.nextLine();
  }

  // Method to display employee details
  void displayEmployeeDetails() {
    displayDetails();
    System.out.println("Employee ID: " + employeeId);
  }
}

// Derived class Student extending Person
class Student extends Person {

  int rollNumber;

  // Method to read student details
  void readStudentDetails() {
    readDetails();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Roll Number: ");
    rollNumber = scanner.nextInt();
  }

  // Method to display student details
  void displayStudentDetails() {
    displayDetails();
    System.out.println("Roll Number: " + rollNumber);
  }
}

public class lab4 {

  public static void main(String[] args) {
    // Display details of 5 students
    System.out.println("Enter details of 5 students:");
    Student[] student = new Student[5];
    for (int i = 0; i < 5; i++) {
      student[i] = new Student();
      student[i].readStudentDetails();
      System.out.println("Details of Student " + (i + 1) + ":");
      student[i].displayStudentDetails();
      System.out.println();
    }

    // Display details of 5 employees
    System.out.println("Enter details of 5 employees:");
    Employee[] employee = new Employee[5];
    for (int i = 0; i < 5; i++) {
      employee[i] = new Employee();
      employee[i].readEmployeeDetails();
      System.out.println("Details of Employee " + (i + 1) + ":");
      employee[i].displayEmployeeDetails();
      System.out.println();
    }
  }
}
