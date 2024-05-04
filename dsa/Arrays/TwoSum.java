import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static class Pair {
    int first;
    int second;
    Pair (int _first, int _second) {
      this.first = _first;
      this.second = _second;
    }
  }
  static Pair brute(int[] arr, int target) {
    for (int i=0; i<arr.length; i++) {

      for (int j=i+1; j<arr.length; j++) {
        if ((arr[i] + arr[j]) == target) {
          return new Pair(i, j);
        }
      }

    }
    return new Pair(-1, -1);
  }

  static Pair better(int[] arr, int target) {
    // hashing
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    // element -> index

    for (int i=0; i<arr.length; i++) {
      int lookFor = target - arr[i];

      if (mp.containsKey(lookFor)) {
        return new Pair(mp.get(lookFor), i);
      }
      mp.put(arr[i], i);
    }
    return new Pair(-1, -1);
  }

  static boolean optimal(int[] arr, int target) {
    // two pinter approach with greedy
    
    int left = 0, right = arr.length - 1;
    ArrayList<Integer> al = new ArrayList<Integer>();
    for (int i=0; i<arr.length; i++) {
      al.add(arr[i]);
    }
    Collections.sort(al);

    while (left < right) {
      int sum = al.get(left) + al.get(right);

      if (sum == target) {
        return true;
      }

      else if (sum < target) {
        // Increase the sum by increasing the left pointer
        left++;
      }

      else {
        // Decrease the pointer by decreasing the right pointer
        right--; 
      }
    } 
    return false;
  }

  public static void main(String[] args) {
    int arr[] = {2,6,5,11,8}, target = 14;
    // Pair ans = brute(arr, target);
    // Pair ans = better(arr, target);
    boolean ans = optimal(arr, target);
    // System.out.println("Answer => " + ans.first + " , " + ans.second);
    System.out.println("Answer => " + ans);
  }
}
