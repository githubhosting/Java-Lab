import java.util.Scanner;

public class lab8 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.print("Enter the numerator : ");
      int numerator = scanner.nextInt();

      System.out.print("Enter the denominator : ");
      int denominator = scanner.nextInt();

      if (numerator < 0 || denominator < 0) {
        throw new IllegalArgumentException();
      }

      if (denominator == 0) {
        throw new ArithmeticException();
      }

      int result = numerator / denominator;
      System.out.println("Result of division: " + result);
    } catch (IllegalArgumentException e) {
      System.out.println(
        "IllegalArgumentException: Both the numbers should be non-negative"
      );
    } catch (ArithmeticException e) {
      System.out.println("ArithmeticException: Cannot divide by zero");
    } finally {
      System.out.println("Program execution complete.");
    }
  }
}
