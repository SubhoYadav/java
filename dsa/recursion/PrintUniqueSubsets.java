// Map Practice and Print Unique subsets problem
// https://www.geeksforgeeks.org/map-interface-java-examples/
import java.util.*;
public class PrintUniqueSubsets {
  static void mapOperations() {
    Map<String, Integer> hm = new HashMap<String, Integer>();
    hm.put("a", new Integer(100));
    hm.put("b", new Integer(200));
    hm.put("c", new Integer(300));
    System.out.println(hm);
    System.out.println(hm.entrySet());
    System.out.println(hm.containsKey("A"));
    System.out.println(hm.containsKey("a"));
    System.out.println(hm.containsValue(300));
    System.out.println(hm.containsValue(3000));
    System.out.println(hm.keySet());

    for(Map.Entry<String, Integer> entry : hm.entrySet()) {
      System.out.println("Key = " + entry.getKey() + "\n" + "Value = " + entry.getValue());
    }
  }

  static void solve(String inpt, String otpt, Map<String, Integer> mp) {
    if (inpt.length() == 0) {
      mp.put(otpt, 1);
      return;
    }

    solve(inpt.substring(1), otpt+inpt.charAt(0), mp);
    solve(inpt.substring(1), otpt, mp);
  }
  public static void main(String args[]) {
    mapOperations();
    // Map<String, Integer> mp = new HashMap<String, Integer>();
    // String inpt = "aab";
    // solve(inpt, "", mp);
    // System.out.println("Result = " + mp.keySet());
  }
}
