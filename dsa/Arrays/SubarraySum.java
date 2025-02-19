// NOTES MADE
import java.util.*;
public class SubarraySum {
    static int brute (int[] arr, int target) {
        int count = 0;
        // generate all subarrays 
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                int sum = 0;

                for (int k=i; k<=j; k++) {
                    sum += arr[k];
                }

                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }

    static int better (int[] arr, int target) {
        int count = 0, sum;
        // generate all subarrays 
        for (int i=0; i<arr.length; i++) {
            sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];

                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }

    static int optimal (int[] arr, int target) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, 1);

        for (int i=0; i<arr.length; i++) {
            prefixSum += arr[i];
            int lookup = prefixSum - target;

            if (mp.get(lookup) != null) {
                count += mp.get(lookup);
            }
            
            mp.put(
                prefixSum, 
                (mp.get(prefixSum) == null ? 1 : mp.get(prefixSum) + 1)
            );
        }

        return count;
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int target = 3;

        // int ans = brute(arr, target);
        // int ans = better(arr, target);
        int ans = optimal(arr, target);
        System.out.println("Subarrays: " + ans);
    }
}