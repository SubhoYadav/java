public class SortArrOf012 {

  static void utilSwap(int arr[], int indx1, int indx2) {
    int temp = arr[indx1];
    arr[indx1] = arr[indx2];
    arr[indx2] = temp;
  }

  static void better(int arr[]) {
    int count0 = 0, count1 = 0, count2 = 0;

    // count the no. of 0s, 1s and 2s
    for (int i=0; i<arr.length; i++) {

      if (arr[i] == 0) count0++;
      else if (arr[i] == 1) count1++;
      else count2++;

    }

    // replace the 0s 1s and 2s in the array

    for (int i=0; i<count0; i++) {
      arr[i] = 0;
    }

    for (int i=count0; i<(count0 + count1); i++) {
      arr[i] = 1;
    }

    for (int i=(count0 + count1); i<arr.length; i++) {
      arr[i] = 2;
    }
  }

  static void optimal (int []arr) {
    // Dutch National Flag Algo
    /**
     * RULES:
     * Everything from 0 to low-1 is 0
     * Everything from low to mid-1 is 1
     * Everything from high+1 to n-1 is 2
     * Everything from mid to high is unsorted
     */

     int n = arr.length;
     int low = 0, mid = 0, high = n-1;

     while (mid <= high) {
      if (arr[mid] == 0) {
        utilSwap(arr, low, mid);
        low++;
        // since we swapped mid with low and low is the place from where 1 begins we have swapped mid with a 1 so move mid by 1 place
        mid++;
      }

      else if (arr[mid] == 1) {
        mid++;
      }

      else {
        utilSwap(arr, mid, high);
        high--;
      }
     }
  }
  public static void main(String[] args) {
    int arr[]= {0,1,2,0,1,2,1,2,0,0,0,1};
    // brute force will be to sort the array
    // better(arr);
    optimal(arr);
    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
