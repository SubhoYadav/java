import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
  static ArrayList<Integer> solve(int[] a1, int[] a2, int n1, int n2) {
    // ArrayList<Integer> visited = new ArrayList<Integer>(0); This is how we fill and create an arraylist at the same time
    ArrayList<Integer> result = new ArrayList<Integer>();
    int smallerArrLength, largerArrLength;
    
    if (n1 >= n2) {
      largerArrLength = n1;
      smallerArrLength = n2;
    }
    else {
      largerArrLength = n2;
      smallerArrLength = n1;
    }

    int[] visited = new int[smallerArrLength];
    for(int i=0; i<smallerArrLength; i++) visited[i] = 0;

    for (int i=0; i<largerArrLength; i++) {
      for (int j = 0; j<smallerArrLength; j++) {
        // for every element in the larger array, see if there is a corressponding element in the smaller array or not and the element must not been taken into account previously, take the help of the visited array
        // Actually! u can event start with the smaller array
        if (a2[j] == a1[i] && visited[j] != 1) {
          result.add(a1[i]);
          visited[j] = 1;
          break; // break out and pick the next element
        }

        // If at any point the element in the second array, is greater than the element we are trying to intersect with, break off, as the array is sorted and u will never find any such elements further
        if (a2[j] > a1[i]) break; 
      }
    }
    return result;
  }

  static ArrayList<Integer> solve_optimal(int[] a1, int[] a2, int n1, int n2) {
    int i=0, j=0;
    ArrayList<Integer> result = new ArrayList<Integer>();
    while(i<n1 && j<n2) {
      if(a1[i] < a2[j]) {
        i++; // need to find a bigger number from a1 to match with a2 so increment a1 pointer
      }
      else if(a2[j] < a1[i]) {
        j++; // need to find a bigger number from a2 to match with a1 so increment a2 pointer
      }
      else {
        // whenever u get a match store it into the result and increment both the pointers
        result.add(a1[i]); 
        i++;
        j++;
        // HANDLE THE EQUALITY CASE IN ELSE BLOCK
      }
    }
    return result;
  }
  public static void main(String args[]) {
    int [] a1 = {1,2,2,3,3,4,5,6};
    int[] a2 = {2,3,3,5,6,6,7};
    ArrayList<Integer> result = solve(a1,a2,a1.length, a2.length);
    System.out.println("Intersection => " + result);
    result = solve_optimal(a1,a2,a1.length, a2.length);
    System.out.println("Intersection optimal => " + result);
  }
}
