import java.util.*;
public class JosephusProblem {
  static int solve(ArrayList<Integer> person, int k, int start_index) {
    // base case
    if (person.size() == 1) return person.get(0);

    // Remove the start_index + (k-1)th element from the array
    int index = (start_index + k) % person.size();
    /* The person adjacent to the dead person, in the clockwise manner will take the position of the dead man.
     * so passing the position of the dead man in the next recursive call.
     */
    person.remove(index); // iterating the array in a circular fashion 
    int ret = solve(person, k, index);

    // default return statement that is never going to execute
    return ret;
  }
  public static void main(String args[]) {
    int n=40, k=7;
    ArrayList<Integer> person = new ArrayList<Integer>();
    for (int i=0; i<n; i++) {
      person.add(i+1);
    }

    k--; // since the person to be eliminated is index + (k-1)
    int ans = solve(person, k, 0);
    System.out.println("Result = " + ans);
  }
}