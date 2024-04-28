import java.util.*;

/**
 * PATTERN: MIN(max) / MAX(min)
 * We have to place the cows in such a way that the minimum distance between the cows is maximum
 * The first cow will go to a[0]
 * APPROACH: find the range of distances, choose a distance as a min distance and see if we can place the cows or not if we can, then increase the min distance between the cows because we have to find the maximum among these minimum distances.
 */
public class AgressiveCows {
  
  // For a given min distance and no. of cows, the function returns whether all the cows can be placed in the stall or not
  static boolean canBePlaced(ArrayList<Integer> al, int dist, int noCows) {
    Integer cows = 1, lastPos = al.get(0);

    for(int i=1; i<al.size(); i++) {
      if(al.get(i) - lastPos >= dist) {
        cows ++;
        lastPos = al.get(i);
      } 
    }

    if(cows >= noCows) return true;
    else return false;
  }

  // Performs the BS
  static int solve(ArrayList<Integer> al, int noCows) {
    int low = 1, high = Collections.max(al), ans = -1;
    
    while(low <= high) {
      int mid = (low + high) / 2;
      boolean b = canBePlaced(al, mid, noCows);

      if(b) {
        low = mid + 1; // increase the minimum distance between the cows
        ans = mid;
      } 
      else high = mid - 1;
    }
    return ans;
  }

  public static void main(String args[]) {
    // 4 2 1 3 6
    // 0 3 4 7 9 10
    ArrayList<Integer> al = new ArrayList<Integer>();

    // al.add(0); al.add(3); al.add(4); al.add(7); al.add(9); al.add(10);
    al.add(4); al.add(2); al.add(1); al.add(3); al.add(6);

    Collections.sort(al);

    int result = solve(al, 2);
    System.out.println("Answer => " + result);
  }
}
k