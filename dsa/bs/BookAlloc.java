// Minimum no. of pages I can allocate to a student = Max(arr)
// Maximum no. of pages = Sum(arr) 

import java.util.ArrayList;
import java.util.Collections;
public class BookAlloc {
    // Returns the no. of students the books are distributed to
    static int distributed(ArrayList<Integer> a, int page) {
        int student = 1, current = a.get(0);

        for(int i=1; i<a.size(); i++) {
            if ((current + a.get(i)) <= page) {
                current += a.get(i);
            }
            else {
                student ++;
                current = a.get(i);
            }
        }

        return student;
    }

    // calculates the sum of all the pages in the book
    static int add(ArrayList<Integer> a) {
        int sum = 0;
        for(int i=0; i<a.size(); i++) {
            sum += a.get(i);
        }
        
        return sum;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        int low = Collections.max(arr);
        int high = add(arr), min = Integer.MAX_VALUE;

        if(arr.size() < m) return -1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            int students = distributed(arr, mid);
            
            if (students == m) {
              System.out.println("mid = "+ mid);
                if (mid < min) {
                  min = mid;
                }
                high = mid -1;
            }
            else if (students > m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;         
    }

    public static void main(String args[]) {
      ArrayList<Integer> arr = new ArrayList<Integer>();

      // 1 17 14 9 15 9 14 

      arr.add(1);
      arr.add(17);
      arr.add(14);
      arr.add(9);
      arr.add(15);
      arr.add(9);
      arr.add(14);

      int result = findPages(arr, 7, 7);
      // int result = distributed(arr, 10);
      System.out.println("Result => " + result);
    }
}