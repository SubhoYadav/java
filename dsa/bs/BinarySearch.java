public class BinarySearch {

    static int iterativeBS(int[] a, int target) {
     int low = 0, high = a.length - 1;
     while(low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] == target) return mid;
        else if (a[mid] > target) high = mid - 1;
        else low = mid + 1;
     }
     return -1;
    }
    static int recursiveBS(int[] a, int low, int high, int target) {
        // base case
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (a[mid] == target) return mid;
        else if (a[mid] > target) return recursiveBS(a, low, (mid + 1), target);
        return recursiveBS(a, (mid + 1), high, target);
    }
    public static void main(String a[]) {
      int arr[] = {3, 4, 6, 7, 9, 12, 16, 17};
    //   int result = iterativeBS(arr, 12);
      int result = recursiveBS(arr, 0, (arr.length -1), 81);
      System.out.println("Result = " + result);
    }
}