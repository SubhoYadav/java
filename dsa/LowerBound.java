public class LowerBound {
    static int LowerBound(int arr, int k) {
        // k is the number for which we are trying to find a lower bound
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // even if there does not exist a lower bound the hypothetical index is always my answer
        while(low < high) {
          int mid = (low + high) / 2;
          if (arr[mid] >= k) {
            // mid could be the lowest index viz arr[mid] >= k
            ans = mid;
            // go to the left to find the lowest index
            high = mid - 1;
          }
          else {
            // go to the right because if arr[mid] is not >= n
          }
        }
    }
    public static void main(String args[]) {

    }
}