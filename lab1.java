// 1.	Write a java program:
// a.	To calculate and display the roots of Quadratic Equation.
// b.	To multiply two arrays and display the result.
// c.	To sort the elements in ascending and descending order using bubble sort algorithm.


// To Calculate Roots
import java.util.Scanner;

public class lab1a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient 'a': ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient 'b': ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient 'c': ");
        double c = scanner.nextDouble();

        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            double root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            double root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.println("Root 1: " + root1 + " and Root 2: " + root2);
        }
        else if (determinant == 0) {
            double root = -b / (2 * a);
            System.out.println("Root: " + root);
        }
        else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-determinant) / (2 * a);
            System.out.println("Root 1: " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2: " + realPart + " - " + imaginaryPart + "i");
        }

        scanner.close();
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
