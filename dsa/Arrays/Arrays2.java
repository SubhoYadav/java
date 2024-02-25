public class Arrays2 {
  static void rotateArrayBetter(int[] arr, int n, int steps) {
    // If we rotate an array by n steps, where n = size of the array, we get the original array back
    steps = steps % n;
    
    // storing the first "step" elements of the array
    int[] temp = new int[steps];
    for(int i=0;i<steps;i++) {
      temp[i] = arr[i];
    }

    // rotating the array by "steps" places
    for(int i=steps; i<arr.length;i++) {
      arr[i-steps] = arr[i];
    }
    
    // Placing the elements from temp to arr
    for(int i=0;i<temp.length; i++) {
      arr[n-steps+i] = temp[i];
    }
    for(int i=0;i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  static int[] utilReverse(int[] arr, int start, int end) {
    // Reversing the array using two-pointer technique
    int i=start, j=end;
    while(i<j) {
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
      i++;
      j--;
    }
    return arr;
  }

  static void rotateOptimal(int[] arr, int n, int steps) {
    steps = steps % n;

    arr = utilReverse(arr, 0, steps - 1);
    for(int i=0;i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    arr = utilReverse(arr, steps, n-1);
    for(int i=0;i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    arr = utilReverse(arr, 0, n-1);
    for(int i=0;i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    // for(int i=0;i<arr.length; i++) {
    //   System.out.print(arr[i] + " ");
    // }
    // System.out.println();
  }
  public static void main(String args[]) {
    int arr[] = {1,2,3,4,5,6,7};
    // rotateArrayBetter(arr, arr.length, 2);
    rotateOptimal(arr, arr.length, 4);
  }
}
