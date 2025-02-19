import java.util.Arrays;
import java.util.*;

public class ConsecutiveSequence {
    static boolean linearSeqarch(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) return true;
        }
        return false;
    }

    static int brute(int[] arr) {
        int longest = 1;
        int n = arr.length;

        for (int i=0; i<n; i++) {
            int begin = arr[i];
            int count = 1;

            while(linearSeqarch(arr, begin + 1)) {
                count++;
                begin = begin+1;
            }

            longest = Math.max(count, longest);
        }
        return longest;
    }

    static int better(Integer[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
        Collections.sort(al);
        int longest = 1, currSmallest = Integer.MIN_VALUE, currCount = 1;

        for (int i=0; i<al.size(); i++) {
            if (al.get(i)-1 == currSmallest) {
                currCount++;
                currSmallest = al.get(i);
            }
            else if (al.get(i) != currSmallest) {
                currCount = 1;
                currSmallest = al.get(i);
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }

    static int optimal(Integer[] arr) {
        int longest = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i: set) {
            if (!set.contains(i-1)) {
                // the current element is not the starting of the sequence
                int count = 1;
                int start = i;
                while(set.contains(start+1)) {
                    start += 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int arr[] = {102,4,100,1,101,3,2,1,1};
        Integer arr2[] = {102,4,100,1,101,3,2,1,1};
        // int ans = brute(arr);
        // int ans = better(arr2);
        int ans = optimal(arr2);
        System.out.println("Answer: " + ans);
    }
}
