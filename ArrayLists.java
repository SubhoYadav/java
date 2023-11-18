import java.util.*;
public class ArrayLists {
    public static void main(String args []) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // ArrayList is a collection of objects so primitive int cannot be used as its type

        for (int i=0; i<=5; i++) {
            arrayList.add(i);
        }
        // Enhanced for loop
        for (Integer n : arrayList) {
            System.out.println(n);
        }
        System.out.println("Element = " + arrayList.get(4));
    }
}