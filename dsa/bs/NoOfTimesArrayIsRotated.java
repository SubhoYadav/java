// Given a rotated sorted array find how many times the array has been rotated
/*
 * INTUITION: Find the minimum element in the rotated sorted array, the index of that element tells you how many times 
 * The array is rotated cause every time the array is rotated the index of minimum element increases by 1 and if the 
 * array was sorted brfore rotation, the min element will be at index 0 and the array is rotated 0 times 
 */

public class NoOfTimesArrayIsRotated {
  static int find(int[] a) {
    int low = 0, high = a.length - 1, minimum = Integer.MAX_VALUE;
    int index = 0; // Index of the min element

    while(low <= high) {
      int mid = (low + high) / 2;

      // check if left half is sorted
      if (a[low] <= a[mid]) {
        // check whether a[low] < minimum
        if (a[low] < minimum) {
          minimum = a[low];
          index = low;
        }
        low = mid + 1;
      }
      // check if right half is sorted
      else if (a[mid] <= a[high]) {
        // check whether a[mid] < minimum
        if (a[mid] < minimum) {
          minimum = a[mid];
          index = mid;
        }
        high = mid - 1; 
      }
    }
    return index;
  }
  public static void main(String a[]) {
    int arr[] = {3,4,5,1,2};
    int result = find(arr);
    System.out.println("Result = " + result);

  }
}