import java.util.*;
public class ArrayLists {
    static void modify (ArrayList<Integer> a) {
        a.remove(a.size() - 1);
    }
    public static void main(String args []) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // ArrayList is a collection of objects so primitive int cannot be used as its type

        for (int i=0; i<=5; i++) {
            arrayList.add(i);
        }
        System.out.println("Array List element at 2" + arrayList.get(2));
        System.out.println("Size of array list " + arrayList.size());
        // Enhanced for loop
        for (Integer n : arrayList) {
            System.out.println(n);
        }
        System.out.println("Element = " + arrayList);
        modify(arrayList);
        System.out.println("Element = " + arrayList);
    }
}