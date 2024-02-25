/**
 * Print N bit binary number having # of 1s >= # of 0s in any of its prefixes
 * After drawing the recursive tree we can conclude that, we have a choice of zero, only when # of 1s > # of 0s
 */
import  java.util.*;
public class NBitBinaryNum {
  static void solve(int zeros, int ones, int n, ArrayList<Integer> output) {
    if (n == 0) {
      System.out.println(output);
      return;
    }
    // We always have a choice of 1 
    output.add(1);
    solve(zeros, ones+1, n-1, output);
    if (ones > zeros) { 
      output.add(0);
      solve(zeros+1, ones, n-1, output);
    }
  }
  public static void main(String args[]) {
    int n = 3;
    int zeros = 0, ones = 0;
    ArrayList<Integer> output = new ArrayList<Integer>();
    solve(zeros, ones, n, output);
  }
}
