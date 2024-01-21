import java.util.Scanner;

public class Lab_1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 1. Calculate Area of Rectangle
    System.out.println("Enter the length of the rectangle:");
    double length = scanner.nextDouble();
    System.out.println("Enter the width of the rectangle:");
    double width = scanner.nextDouble();
    double area = calculateRectangleArea(length, width);
    System.out.println("The area of the rectangle is " + area);

    // 2. Multiply Two Arrays
    System.out.println("Enter the length of the array:");
    int arrLen = scanner.nextInt();
    int[] arr1 = readArray("first", arrLen);
    int[] arr2 = readArray("second", arrLen);
    int[] resultArr = multiplyArrays(arr1, arr2);
    printResult(resultArr);

    // 3. Bubble Sort an Array
    int[] arr = readArray(arrLen);
    bubbleSortDescending(arr);
    printArray("After bubble sorting the array in descending order:", arr);
    bubbleSortAscending(arr);
    printArray("After bubble sorting the array in ascending order:", arr);
  }

  public static double calculateRectangleArea(double length, double width) {
    return length * width;
  }

  public static int[] readArray(String ordinal, int arrLen) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[arrLen];
    System.out.println("Enter the elements of the " + ordinal + " array:");
    for (int i = 0; i < arrLen; i++) {
      arr[i] = scanner.nextInt();
    }
    return arr;
  }

  public static int[] multiplyArrays(int[] arr1, int[] arr2) {
    int arrLen = arr1.length;
    int[] resultArr = new int[arrLen];
    for (int i = 0; i < arrLen; i++) {
      resultArr[i] = arr1[i] * arr2[i];
    }
    return resultArr;
  }

  public static void bubbleSortDescending(int[] arr) {
    int arrLen = arr.length;
    for (int i = 0; i < arrLen; i++) {
      for (int j = 0; j < arrLen - i - 1; j++) {
        if (arr[j] < arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void bubbleSortAscending(int[] arr) {
    int arrLen = arr.length;
    for (int i = 0; i < arrLen; i++) {
      for (int j = 0; j < arrLen - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void printArray(String message, int[] arr) {
    System.out.println(message);
    for (int value : arr) {
      System.out.println(value);
    }
  }

  public static void printResult(int[] resultArr) {
    System.out.println("The result of array multiplication:");
    for (int value : resultArr) {
      System.out.println(value);
    }
  }
}
