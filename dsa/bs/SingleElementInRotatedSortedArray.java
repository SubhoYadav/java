// Given an array where apart from an element, all other elements are present exactly twice, You have to find the element that appears only once in such an array

/*
 * [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
 *  0  1  2  3  4  5  6  7  8  9  10 <= INDEX
 * 
 * INTUITION: The pairs can be (even, odd) or (odd, even) [taking the indexes]
 * If the pair is (even, odd) I am on the left of the target
 * If the pair is (odd, even) I am on the right of the target 
 * 
 * TRICK: If you want to avoid writing a lot of edge cases, trim down your search space ny one element on eiether sides
 * and handle those elements as a separate case
 */

 public class SingleElementInRotatedSortedArray {

  static int find(int[] arr) {
    int n = arr.length;
    int low = 1, high = n-2;

    // If the array contains a single element
    if (n == 1) return arr[0];

    // since the search space is trimmed, handle those cases
    if (arr[0] != arr[1]) {
      return arr[0];
    }
    if (arr[n-1] != arr[n-2]) {
      return arr[n-1];
    }

    while(low <= high) {
      int mid = (low + high) / 2;

      // Check whether the element at mid is out result
      if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) return arr[mid];

      // Check if we are on the left half
      if (mid % 2 !=0 && arr[mid - 1] == arr[mid] ||
          mid % 2 == 0 && arr[mid + 1] == arr[mid]) {

            // my element is on the right half
            low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return -1;
  }
  public static void main(String a[]) {
    int array[] = {1,1,2,3,3,4,4,5,5,6,6};
    int result = find(array);
    System.out.println("Result = " + result);
  }
 }