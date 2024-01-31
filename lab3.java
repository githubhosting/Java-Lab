// 3.	Write a Java program using encapsulation and constructors to create a class to represent a complex number and perform the following operations:
// a.	Addition of two complex numbers
// b.	Subtraction of two complex numbers
// c.	Compare two complex numbers.

//complex numbers
import java.util.Scanner;

class complex {

  int real, imaginary;

  public complex() {
    this.real = 0;
    this.imaginary = 0;
  }

  public complex(int r, int i) {
    this.real = r;
    this.imaginary = i;
  }

  public void display() {
    System.out.println("Real part: " + this.real);
    System.out.println("Imaginary part: " + this.imaginary);
  }

  public complex addComplex(complex c2) {
    complex c3 = new complex();
    c3.real = this.real + c2.real;
    c3.imaginary = this.imaginary + c2.imaginary;
    return c3;
  }

  public complex subComplex(complex c2) {
    complex c3 = new complex();
    c3.real = this.real - c2.real;
    c3.imaginary = this.imaginary - c2.imaginary;
    return c3;
  }

  public boolean isEqual(complex c2) {
    return this.real == c2.real && this.imaginary == c2.imaginary;
  }

  public void increment() {
    this.real++;
    this.imaginary++;
  }

  public void decrement() {
    this.real--;
    this.imaginary--;
  }
}

public class lab3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter real no of first complex number");
    int r1 = sc.nextInt();
    System.out.println("Enter imaginary no of first complex number");
    int i1 = sc.nextInt();
    System.out.println("Enter real no of second complex number");
    int r2 = sc.nextInt();
    System.out.println("Enter imaginary no of second complex number");
    int i2 = sc.nextInt();

    complex c1 = new complex(r1, i1);
    complex c2 = new complex(r2, i2);
    while (true) {
      System.out.println(
        "\n1.add\n2.subract\n3.increment\n4.decrement\n5.exit\n"
      );
      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          {
            complex c3 = c1.addComplex(c2);
            c3.display();
            break;
          }
        case 2:
          {
            complex c3 = c1.subComplex(c2);
            c3.display();
            break;
          }
        case 3:
          {
            c1.increment();
            c1.display();
            break;
          }
        case 4:
          {
            c1.decrement();
            c1.display();
            break;
          }
        case 5:
          {
            System.exit(0);
          }
        default:
          System.out.println("Invalid choice\n");
      }
      sc.close(); // Close scanner
    }
  }
}
