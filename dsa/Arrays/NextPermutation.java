// Notes made
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The algo is based on the arrangement of words in a dictionary, by finding the longest common prefix and then finding
 * just the next word in the sequence
 * 
 * step:1 => Find the breakpoint from where the graph declines
 * step:2 => swap the el at break point with an el just greater than the el at breakpoint
 * step:3 => reverse the right half
 */

public class NextPermutation {
    static ArrayList<Integer> solve(ArrayList<Integer> al) {
        int indx = -1;
        int n = al.size();

        for (int i=n-2; i>=0; i--) {
            if (al.get(i) < al.get(i+1)) {
                indx = i;
                break;
            }
        }
        if (indx == -1) {
            // last member of the permutation, fallback to the first one
            Collections.reverse(al);
            return al;
        }

        for (int i=n-1; i>=indx; i--) {
            if (al.get(i) > al.get(indx)) {
                // swap the elements at i and indx
                Integer t = al.get(indx);
                al.set(indx, al.get(i));
                al.set(i, t);
                break;
            }
        }

        // reverse the list segment (indx+1, al.size())
        Collections.reverse(al.subList(indx + 1, al.size()));
        return al;
    }
    public static void main(String[] args) {
        // [2,1,5,4,3,0,0]
        // Integer[] arr = {2,1,5,4,3,0,0};
        Integer[] arr = {1,3,2};
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));

        ArrayList<Integer> ans = solve(al);
        System.out.println(ans);
    }
}
