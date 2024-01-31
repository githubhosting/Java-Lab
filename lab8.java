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
        throw new IllegalArgumentException(
          "IllegalArgumentException: Both the numbers should be non-negative"
        );
      }

      if (denominator == 0) {
        throw new ArithmeticException("ArithmeticException: Cannot divide by zero");
      }

      int result = numerator / denominator;
      System.out.println("Result of division: " + result);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Program execution complete.");
    }
  }
}

// All the types of exception in java
// 1. ArithmeticException
// 2. ArrayIndexOutOfBoundsException
// 3. ClassNotFoundException
// 4. FileNotFoundException
// 5. IOException
// 6. InterruptedException
// 7. NoSuchFieldException
// 8. NoSuchMethodException
// 9. NullPointerException
// 10. NumberFormatException
// 11. RuntimeException
// 12. StringIndexOutOfBoundsException
// 13. UnsupportedOperationException
