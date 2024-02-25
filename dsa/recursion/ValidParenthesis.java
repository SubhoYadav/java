// AKA balanced parenthesis
import java.util.*;

public class ValidParenthesis {
  static void solve(String otpt, int open, int close, ArrayList<String> res) {
    if (open == 0 && close == 0) {
      res.add(otpt);
      return;
    }
    if (open != 0) {
      solve(otpt+"(", open - 1, close, res);
    }

    if (open != close && close != 0) {
      // we can only add a closing parenthesis only if # of open parenthesis != # closed parenthesis
      solve(otpt+")", open, close - 1, res);
    }
  }

  public static void main(String args[]) {
    int n = 2;
    int open =n, close = n;
    ArrayList<String> res = new ArrayList<String>();
    solve("", open, close, res);
    System.out.println("Answer = " + res);
  }
}
