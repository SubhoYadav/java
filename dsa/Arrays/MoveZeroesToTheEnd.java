public class MoveZeroesToTheEnd {
  static int[] utilSwap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
    return arr;
  }

  static void utilPrintArray(int[] arr, int n) {
    for(int i=0; i<n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  static void solve(int[] arr, int n) {
    int j = -1;
    for(int i=0;i<arr.length;i++) {
      if (arr[i] == 0) {
        j=i;
        break;
      }
    }  

    if (j == -1) {
      System.out.println("No zeroes to move at the end");
      utilPrintArray(arr, n);
      return;
    }

    for(int i=j+1; i<n;i++) {
      if (arr[i]!=0) {
        arr = utilSwap(arr, i, j);
        j++;
      }
    }
    utilPrintArray(arr, n);
  }
  public static void main(String args[]) {
    // int [] arr = {1,0,2,3,2,0,0,4,5,1};
    int [] arr = {1,2,3,2,4,5,1};
    solve(arr, arr.length);
  }
}
