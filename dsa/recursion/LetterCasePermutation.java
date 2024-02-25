import java.util.*;
public class LetterCasePermutation {

  static void solve(String inpt, String otpt, ArrayList<String> res) {
    // base case
    if (inpt.length() == 0) {
      res.add(otpt);
      return;
    }
    // single choice
    if (Character.isDigit(inpt.charAt(0))) {
      solve(inpt.substring(1), otpt+inpt.charAt(0), res);
    }
    else {
      solve(inpt.substring(1), otpt+Character.toLowerCase(inpt.charAt(0)), res);
      solve(inpt.substring(1), otpt+Character.toUpperCase(inpt.charAt(0)), res);
    }
  }

  public static void main(String args[]) {
    String inpt = "a1b2", otpt = "";
    ArrayList<String> ans = new ArrayList<String>();

    solve(inpt, otpt, ans);
    System.out.println("Answer = " + ans);
  }
}