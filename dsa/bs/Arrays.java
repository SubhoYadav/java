// ** Use bs algo where the search space is limited & sorted
import java.util.Scanner;
public class BinarySearch {
    public static void main(String a[]) {

        static int[] inputArray () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the array :");
            int size = sc.nextInt();
            int array[] = new int[size];
            System.out.println("Enter the elements of the array :");
            for (int i = 0; i <= size - 1; i++) {
                array[i] = sc.nextInt();
            }
            return array;
        }

        // Printing the array elements
        static void printArray(int [] array, int size) {
          for (int i = 0; i <= size - 1; i++) {
            System.out.print(array[i] + " , ");
           }
           System.out.println();
        }
        
        int a[] = inputArray();
        printArray(a, 5);

        // int array[] = { 3, 4, 6, 7, 9, 12, 16, 18};
        // System.out.println(array);
    }
}

