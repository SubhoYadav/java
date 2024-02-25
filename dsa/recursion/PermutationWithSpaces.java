// I am putting a $ sign in place of 
import java.util.*;
public class PermutationWithSpaces {
  static void solve(String inpt, String otpt, ArrayList<String> res) {
    if (inpt.length() == 0) {
      res.add(otpt);
      return;
    }

    solve(inpt.substring(1), otpt+inpt.charAt(0), res);
    solve(inpt.substring(1), otpt+inpt.charAt(0)+"$", res);
  }
  public static void main(String args[]) {
    String inpt = "ABC";
    ArrayList<String> ans = new ArrayList<String>();

    solve(inpt, "", ans);
    System.out.println(ans);
  }
}
