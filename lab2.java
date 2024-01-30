// 2.	Write a java program to create an Employee database which stores following information about the Employee: Name, Emp_id, department, age, and designation. Perform the following operations:
// a.	Read and display the details of at least five Employees.
// b.	Calculate and display the sum of salary of all the employees of “sales” department.
// c.	Retrieve the details of “highest paid manager” in the purchase department.

import java.util.Scanner;

class Employee {

  // Attributes to store employee information
  String name, department, designation;
  int employeeId, age;
  double salary;

  // Constructor to initialize employee object
  public Employee(
    String name,
    int employeeId,
    String department,
    int age,
    String designation,
    double salary
  ) {
    this.name = name;
    this.employeeId = employeeId;
    this.department = department;
    this.age = age;
    this.designation = designation;
    this.salary = salary;
  }

  // Method to display employee details
  public void display() {
    System.out.println(
      "Name: " +
      name +
      ", ID: " +
      employeeId +
      ", Department: " +
      department +
      ", Age: " +
      age +
      ", Designation: " +
      designation +
      ", Salary: " +
      salary
    );
  }
}

public class lab2 {

  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);
    Employee[] employees = new Employee[5]; // Array to store employee objects

    // Reading details for 5 employees
    for (int i = 0; i < 5; i++) 
    {
      System.out.println("Enter details for Employee " + (i + 1));
      System.out.print("Name: ");
      String name = scanner.nextLine();
      System.out.print("ID: ");
      int id = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      System.out.print("Department: ");
      String dept = scanner.nextLine();
      System.out.print("Age: ");
      int age = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      System.out.print("Designation: ");
      String desig = scanner.nextLine();
      System.out.print("Salary: ");
      double sal = scanner.nextDouble();
      scanner.nextLine(); // Consume newline
      employees[i] = new Employee(name, id, dept, age, desig, sal);
    }

    // Displaying details of all employees
    System.out.println("\nEmployee Details:");
    for (Employee emp : employees) 
    {
      emp.display();
    }

    // Calculating sum of salaries in the Sales department
    double totalSalesSal = 0;
    for (Employee emp : employees) 
    {
      if (emp.department.equalsIgnoreCase("sales")) 
      {
        totalSalesSal += emp.salary;
      }
    }
    System.out.println("\nTotal Salary in Sales Department: " + totalSalesSal);

    // Finding highest paid manager in Purchase department
    Employee highestPaidManager = null;
    for (Employee emp : employees) 
    {
      if (
        emp.department.equalsIgnoreCase("purchase") &&
        emp.designation.equalsIgnoreCase("manager")
      ) {
        if (emp.salary > highestPaidManager.salary) 
        {
          highestPaidManager = emp;
        }
      }
    }

    if (highestPaidManager != null) {
      System.out.println("\nHighest Paid Manager in Purchase Department:");
      highestPaidManager.display();
    } else {
      System.out.println("\nNo manager found in Purchase Department.");
    }

    scanner.close(); // Closing scanner resource
  }
}
