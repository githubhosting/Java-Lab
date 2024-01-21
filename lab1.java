//Area of a rectangle
import java.util.Scanner;

public class lab1a {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the length of the rectangle :");
    double length = scanner.nextDouble();
    System.out.println("Enter the width of the rectangle :");
    double width = scanner.nextDouble();
    // double a=60, y=80, z=78;
    System.out.println("The area of the rectangle is " + length * width);
  }
}

//Multiply Two Numbers
import java.util.Scanner;
public class lab1b {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int arrLen = sc.nextInt();
        int[] arr1 = new int[arrLen];
        int[] arr2 = new int[arrLen];
        System.out.println("Enter the elements of the first array");
        for(int i = 0; i<arrLen; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the elements of the second array");
        for(int i = 0; i<arrLen; i++){
            arr2[i] = sc.nextInt();
        }
        int[] resultArr = new int[arrLen];
        for(int i=0;i<arrLen;i++){
            resultArr[i] = arr1[i] * arr2[i];
        }
        System.out.println("The result of array multiplication:");
        for(int i=0;i<arrLen;i++){
            System.out.println(resultArr[i]);
        }
    }
}


//Bubble sort
import java.util.Scanner;
public class lab1c {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int arrLen = sc.nextInt();
        int[] arr = new int[arrLen];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<arrLen;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0;i<arrLen;i++){
            for(int j=0;j< arrLen-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("After bubble sorting the array in descending order");
        for(int i=0;i<arrLen;i++){
            System.out.println(arr[i]);
        }
        for(int i =0;i<arrLen;i++){
            for(int j=0;j< arrLen-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("After bubble sorting the array in ascending order");
        for(int i=0;i<arrLen;i++){
            System.out.println(arr[i]);
        }
    }
}
