// Edge case: [3, 4, 1, 2]

public class MinRotatedSortedArray {
  
  // Finds minimum in a rotated sorted array
  static int find(int a[]) {
    int low = 0, high = a.length - 1;
    int minVal = Integer.MAX_VALUE;

    while(low <= high) {
      int mid = (low + high) / 2;

      // Edge case
      if (a[low] <= a[mid] && a[mid] <= a[high]) {
        if (a[low] < minVal) {
          minVal = a[low];
        }
        break;
      } 
      // Edge case

      // Left half is sorted
     else if (a[low] <= a[mid]) {
        // check whether a[low] is <  our previous value
        if (a[low] < minVal) {
          minVal = a[low];
        }
        low = mid + 1;
      }

      // Right half is sorted
      else if (a[mid] <= a[high]) {
        // check whether the a[mid] < our prev value
        if(a[mid] < minVal) {
          minVal = a[mid];
        }
        high = mid - 1;
      }
    }
    return minVal;
  }

  public static void main(String a[]) {
    int array[] = {3, 4, 1, 2 };
    // System.out.println("Test a");
    int min = find(array);
    System.out.println("Minimum in rotated sorted array: " + min);
  }
}


