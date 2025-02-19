// NOTES MADE
import java.util.ArrayList;
import java.util.Arrays;

/**
 * iterate the array in the question from the end
 * last element will always be the leader
 * store it as maximum
 * if u find any other element that is greater than maximum, you get the next leader
 */
public class Leaders {
    static ArrayList<Integer> brute(ArrayList<Integer> al) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<al.size(); i++) {
            boolean isLeader = true; // we assume that the element at index i is the leader

            for (int j=i+1; j<al.size(); j++) {
                if (al.get(j) > al.get(i)) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader) {
                ans.add(al.get(i));
            }
        }
        return ans;
    }

    static ArrayList<Integer> optimal (ArrayList<Integer> al) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int maximum = Integer.MIN_VALUE;
        // note that the last element in the array is always a leader element cause there is no other el on the right to compare with
        for (int i=al.size()-1; i>=0; i--) {
            if (al.get(i) > maximum) {
                ans.add(al.get(i));
                maximum = al.get(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = {10,22,12,3,0,6};
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
        
        ArrayList<Integer> ans = optimal(al);
        // ArrayList<Integer> ans = brute(al);
        System.out.println(ans);
    }
}
