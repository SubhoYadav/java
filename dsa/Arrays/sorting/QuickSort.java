public class QuickSort {
   static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
   static int partition(int[]arr, int low, int high) {
      int pivot = arr[low];
      int i = low, j = high;
      while (i < j) {
         while (arr[i] <= pivot && i <= (high -1)) {i++;}
         while (arr[j] > pivot && j >= (low - 1)) {j--;}

         if (i < j) {
            swap(arr, i, j);
         }
      }

      swap(arr, low, j);
      return j;
   }
   static void quickSort(int arr[], int low, int high) {
      if (low < high) {
         int partition_index = partition(arr, low, high);
         quickSort(arr, low, partition_index-1);
         quickSort(arr, partition_index+1, high);
      }
   }
   public static void main(String[] args) {
    int[] arr = {4,6,2,5,7,9,1,3};
    
    quickSort(arr, 0, arr.length - 1);

    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
   } 
}
