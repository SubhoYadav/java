// Search in a rotated sorted array (with duplicates)
// Edge case: [3, 1, 2, 3, 3, 3, 3] a[low] == a[mid] == a[high]

/**
 * Whenever u encounter a problem based on duplicates, try solving for unique and then fit the edge case into your solution for unique.
 */
public class SearchRotated2 {
    static boolean search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) return true;

            // edge case 
            if (a[low] == a[mid] && a[mid] == a[high]) {
                // trim down the search space from both the ends
                low ++;
                high --;
                continue;
            }
            // right half is sorted
            else if (a[mid] <= a[high]) {
                // check if target can be present in right half
                if (a[mid] <= target && target <= a[high]) {
                    // continue search in right half
                    low = mid + 1;
                }
                else {
                    // Eliminate the right half
                    high = mid - 1;
                }
            }
            // left half is sorted
            else {
                // check if target can be present in left half
                if (a[low] <= target && target <= a[mid]) {
                    // continue search in left half
                    high = mid - 1;
                }
                else {
                    // Eliminate the left half
                    low = mid + 1;
                }
            }
        }
        return false;
    }
    public static void main(String a[]) {
     int arr[] = {3,1,2,3,3,3,3};
    boolean result = search(arr, 5);
    System.out.println("Result = " + result);
    }
}