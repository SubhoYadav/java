import java.util.HashMap;
import java.util.Map;

public class FindNoThatAppearsOnce {
  // ordered map has a time complexity of NlogN whereas unordered map has a tome complexity of O(N) for insertions 
  static int solve(int[] arr, int n) {
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    // if the map does not contain the key, it will return null
    // HashMap in java is unordered
    for(int i=0; i<n; i++) {
      mp.put(arr[i], ((mp.get(arr[i]) == null) ? 0 : mp.get(arr[i])) + 1);
    } // TC=>O(N)
    
    for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      if (entry.getValue() == 1) return entry.getKey();
    } // TC=>O(N/2 + 1)
    return -1;
  }

  static int solveOptimal(int[] arr, int n) {
    // Leveraging the XOR property of the numbers
    int ans = 0;
    for(int i=0;i<n;i++) {
      ans = ans ^ arr[i];
    }
    return ans;
  }
  public static void main(String args[]) {
    int[] arr = {1,1,2,3,3,8,8};
    int result = solve(arr, arr.length);
    System.out.println("Result = " + result);

    int resultOptimal = solveOptimal(arr, arr.length);
    System.out.println("Result = " + resultOptimal);

  }
}
