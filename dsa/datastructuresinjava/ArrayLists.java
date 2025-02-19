import java.util.*;
import java.util.Arrays;
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

        // Sorting the arrayList
        // ArrayList<Integer> sampleAl = new ArrayList<Integer>();
        // int[] arr = {5,2,4,12,0,3,10,8};

        // for (int i=0; i<arr.length; i++) {
        //     sampleAl.add(arr[i]);
        // }

        // the above array can also be converted to arrayList as follows
        // Always use this syntax with Integer Object Arrays
        Integer[] arr = {5,2,4,12,0,3,10,8};
        ArrayList<Integer> sampleAl = new ArrayList<Integer>(Arrays.asList(arr));

        Collections.sort(sampleAl);
        System.out.println(sampleAl);

        Collections.sort(sampleAl, Collections.reverseOrder());
        System.out.println(sampleAl);

        // reversing a sublist 
        Collections.reverse(sampleAl.subList(0,4)); // from 0 -> 3
        System.out.println(sampleAl);
        
        // Creating an inplace Integer object array 
        System.out.println(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1,1})));

        // Set a value at an index of the arraylist
        sampleAl.set(0, 2000);
        System.out.println(sampleAl);

    }
}