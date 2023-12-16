// Given a number n, find the square root of n rounded to 1 decimal place

/*
 * PATTERN: Binary search on answer 
 * INTUITION: You can eiether deduce the range of binary search or the range of binary search will be given
 * The problem boils down to finding the maximum integer(x) between [1 to n] viz. x*x <= n 
 */

 public class SquareRoot {
  static int find(int n) {
    int low = 0, high = n, ans = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (mid * mid <= n) {
        low = mid + 1;
        ans = mid;
      }
      else high = mid - 1;
    }
    return ans;
  }
  public static void main(String a[]) {
    int n = 25;
    int result = find(n);
    System.out.println("Result = " + result);
  }
 }