package dsa.recursion;

import java.util.ArrayList;

public class SortArray {

  static void insert (ArrayList<Integer> array, int target) {

    // base case
    if (array.get(array.size() - 1 ) <= target || array.size() == 0) {
      array.add(target);
    }

    Integer last = array.get(array.size() - 1);
    array.remove(array.size() -1);
    insert(array, target);
    array.add(last);
  }

  static void sort(ArrayList<Integer> array){
    Integer last = array.get(array.size() - 1);
    array.remove(array.size() -1);

    sort(array);
    // Induction step me "last" ko insert karna hai
    insert(array, last);
  }
  public static void main(String a[]) {
    ArrayList<Integer> array = new ArrayList<Integer>();
    array.add(1);
    array.add(8);
    array.add(5);
    array.add(9);
    array.add(6);

    sort(array);
    System.out.println(array);
  }
}
