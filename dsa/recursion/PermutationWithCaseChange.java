import java.util.*;
// In this problem we have assumed that the letters in the string are all in lower case
public class PermutationWithCaseChange {
  static void solve(String inpt, String otpt, ArrayList<String> res) {
    if (inpt.length() == 0) {
      res.add(otpt);
      return;
    }
    solve(inpt.substring(1), otpt+inpt.charAt(0), res);
    solve(inpt.substring(1), otpt+Character.toUpperCase(inpt.charAt(0)), res);
  }

  public static void main(String args[])  {
    String inpt = "ab";
    ArrayList<String> ans = new ArrayList<String>();
    solve(inpt, "", ans);
    System.out.println("Answer = " + ans);
  }
}
