public class SearchRotated {
    static int search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) return mid;
            // check if right half is sorted
            else if (a[mid] <= a[high]) {
                if (a[mid] <= target && target <= a[high]) {
                    // start searching in the right half
                    low = mid + 1;
                }
                else {
                    // eliminate the right half
                    high = mid - 1;
                }
            }
            // One of the halfs will always be sorted
            else {
                // If the right half is not sorted the left half will always be sorted
                if (a[low] <= target && target <= a[mid]) {
                    // start searching in the left half
                    high = mid - 1;
                }
                else {
                    // eliminate the left half
                    low = mid + 1; 
                }
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {7,8,9,1,2,3,4,5,6};
        int result = search(arr, 5);
        System.out.println("Result " + result);
    }
}