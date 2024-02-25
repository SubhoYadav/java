import java.util.*;
public class PrintSubsets {
  static void solve(String inpt, String otpt, ArrayList<String> res) {
    if (inpt.length() == 0) {
      res.add(otpt);
      return;
    }

    // Once include the first character to the output
    solve(inpt.substring(1), otpt+inpt.charAt(0), res);
    // Don't include the first character in the output
    solve(inpt.substring(1), otpt, res);
  }
  public static void main(String args[]) {
    String inpt = "abcde";
    ArrayList<String> ans = new ArrayList<String>();
    solve(inpt, "", ans);
    System.out.println(ans);
  }
}