public class MaxConsecutiveOne {
  static int solve(int[] arr, int n) {
    int count = 0, max = 0;

    for(int i=0; i<n; i++) {
      if (arr[i] == 1) {
        // keep replacing the max until, u are getting consecutive ones
        count ++;
        if (count > max) max = count;
      }
      else {
        // Once the seq breaks, reset the count of consecutive ones to 0
        count = 0;
      }
    }
    return max;
  }
  public static void main(String args[]) {
    int[]  arr = {1,1,0,1,1,1,0,1,1};
    int result = solve(arr, arr.length);
    System.out.println("Result = " + result);
  }
}