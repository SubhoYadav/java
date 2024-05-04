import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubarray {
  static int brute(int[] arr, int targetSum) {
    int n = arr.length;
    int maxLen = 0;
    // generate all the sub arrays and calculate the sum
    for (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        int sum = 0;

        for (int k=i; k<=j; k++) {
          sum += arr[k];
        }

        if (sum == targetSum) {
          maxLen = Math.max(maxLen, (j-i+1));
        }
      }
    }
    return maxLen;
  }

  static int bruteImproved(int[] arr, int k) {
    int n = arr.length;
    int sum = 0;
    int maxLen = 0;

    for (int i=0; i<n; i++) {

      sum = 0;
      for (int j=i; j<n; j++) {
        sum += arr[j];

        if (sum == k) {
          maxLen = Math.max(maxLen, (j-i+1));
        }
      }
    }
    return maxLen;
  }

  static int better(int[] arr, int k) {
    // This is the optimal soln if the array contains both +ve and -ve numbers

    // using prefix sum and hashing

    // Map stores sum -> length
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

    // calculating the prefix sum
    int sum = 0;
    int maxLen = 0;

    for (int i=0; i<arr.length; i++) {
      sum += arr[i];

      if (sum == k) {
        maxLen = Math.max(maxLen, i+1);
      }

      // see if prefix sum exists previously
      int rem = sum - k;
      if (mp.containsKey(rem) == true) {
        maxLen = Math.max(maxLen, (i+1) - mp.get(rem));
      }

      // update the sum only if it does not exists, because we want the longest subarray, so go as much left as possibel
      if (!mp.containsKey(sum)) {
        mp.put(sum, (i+1));
      } 
    }

    return maxLen;
  }

  static int optimal(int arr[], int k) {
    // Two pointer approach
    // Works only for array with +ve elements
    int left = 0, right = 0; // start with an array of length = 1
    int sum = arr[left];
    int n = arr.length;
    int maxLen = 0;

    while (right < n) {

      // If the sum is > k trim the array from the left
      while (left <= right && sum > k) {
        sum = sum - arr[left];
        left++; // move the leeft pointer 1 step
      }

      // If the sum == k
      if (sum == k) {
        maxLen = Math.max(maxLen, (right - left + 1));
      } 

      right++;
      if (right < n) {
        sum += arr[right];
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,3,1,1,1,1,4,2,3};
    int k = 3;
    // int ans = brute(arr, k);
    // int ans = bruteImproved(arr, k);
    // int ans = better(arr, k);
    int ans = optimal(arr, k);
    System.out.println(ans);
  }
}
