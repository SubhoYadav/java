import java.util.*;
public class Arrays {

  // Find the largest element in an array
  static int findLargest(int[] arr, int n) {
    int largest = arr[0];
    for(int i=0; i<n; i++) {
      if(arr[i] > largest) largest = arr[i];
    }
    return largest;
  }

  // Finds second largest element in the array
  static int findSecondLargest(int[] arr, int n) {
    /*
     Points worth noting
     The array may contain duplicates
     The array may contain identical elements [7,7,7,7] in which case there might not exists a second largest element
     */
    int largest = arr[0], slargest = -1;
    for(int i=1; i<n; i++) {
      if (arr[i] > largest) {
        slargest = largest;
        largest = arr[i];
      }
      else if(arr[i] < largest && arr[i] > slargest) {
        slargest = arr[i];
      }
    }
    return slargest;
  }

  // Find second smallest element in the array
  static int findSecondSmallest(int[] arr, int n) {
    /*
     Points worth noting
     The array may contain duplicates
     The array may contain identical elements [7,7,7,7] in which case there might not exists a second largest element
     */
    int smallest = arr[0], ssmallest = Integer.MAX_VALUE;
    for(int i=1; i<n; i++) {
      if (arr[i] < smallest) {
        ssmallest = smallest;
        smallest = arr[i];
      }
      else if(arr[i] != smallest && arr[i] < ssmallest) {
        ssmallest = arr[i];
      }
    }
    return ssmallest;
  }

  // Check if an array is sorted or not
  static boolean isSorted(int[] arr, int n) {
    for(int i=1; i<n; i++) {
      if(arr[i] >= arr[i-1]) continue;
      else return false;
    }
    return true;
  }

  // Remove duplicates in-place from a sorted array
  static int removeDuplicates(int[] arr, int n) {
    // [1,1,1,2,2,3,3,3,4], you have to return [1,2,3,4,...] 4 which is the total no. of unique elements in the array

    int i = 0;
    for(int j=1; j<n; j++) {
      if (arr[j] != arr[i]) {
        // got the new unique no.
        arr[i+1] = arr[j];
        i++;
      }
    }
    return i+1;
  }

  public static void main(String args[]) {
    // int arr[] = new int[10];
    int arr[] = {3,2,1,5,4,0};
    int arr1[] = {1,1,2,3,4,5};
    int arr2[] = {1,1,1,2,3,4};
    int arr3[] = {1,1,1,2,2,3,3,3,4};

    // System.out.println(arr[0]);

    System.out.println("The largest number in the array is " + findLargest(arr, arr.length));
    System.out.println("The second largest number in the array is " + findSecondLargest(arr, arr.length));
    System.out.println("The second smallest number in the array is " + findSecondSmallest(arr, arr.length));
    System.out.println("arr1 is sorted ? " + isSorted(arr1, arr1.length));
    System.out.println("arr2 is sorted ? " + isSorted(arr2, arr2.length));
    System.out.println("Unique elements in the sorted array = " + removeDuplicates(arr3, arr3.length));
  }
}
