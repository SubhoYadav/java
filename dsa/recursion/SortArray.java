import java.util.ArrayList;
public class SortArray {
  static void insert(ArrayList<Integer> array, Integer el) {
    if (array.size() == 0 || array.get(array.size() -1) <= el) {
        array.add(el);
       return;
    } 
    Integer last = array.get(array.size() - 1);
    array.remove(array.size() - 1);
    insert(array, el);
    array.add(last);
  }
  static void sort(ArrayList<Integer> array) {
    // Base case
    if (array.size() == 1) return;
    Integer last = array.get(array.size() - 1);
    array.remove(array.size() - 1);
    sort(array); // Hypothesis
    insert(array, last);
  }
  public static void main(String a[]) {
    ArrayList<Integer> array = new ArrayList<Integer>();
    array.add(4);
    array.add(8);
    array.add(1);
    array.add(12);
    array.add(3);
    System.out.println(array);
    sort(array);
    System.out.println(array);
  }
}