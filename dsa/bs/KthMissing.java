/**
 * Kth missing number Binary search
 */
public class KthMissing {
  static int solve(int a[], int k) {
    int low = 0, high = a.length - 1;

    while(low <= high) {
      int mid = (low + high) / 2;

      if((a[mid] - (mid + 1)) > k) high = mid - 1;
      else low = mid + 1;
    }
    
    return low + k;
  }

  public static void main(String args[]) {
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 10}, k = 1;
    int result = solve(a, k);
    System.out.println("Answer => " + result);
  }
}
