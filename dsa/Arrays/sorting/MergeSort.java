// The algorithm is following dicide and conquer technique
import java.util.*;

public class MergeSort {
    static void merge (int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <=high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        while (right <= high ) {
            temp.add(arr[right]);
            right++;
        }

        // copy the temp array into the original array
        for (int i=low; i<=high; i++) {
            // low is not always zero because any subset of the array can be passed to the function for the merge
            /*
             * low = 4 and high = 8
             * i = 4 and 
             * temp.get(i - low) = temp.get(4 -4) = 0
             * i = 5
             * temp.get(i - low) = temp.get(5 - 4) = 1
             * So the indices of the temp array is obtained properly irrespective of the value of low and high  
             */
            arr[i] = temp.get(i - low);
        }
    }
    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            // reached the point where the array contains single elements
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        int[] arr = {9,4,7,6,3,1,5};
        int n = arr.length; 
        mergeSort(arr, 0, n-1);

        // Array before sorting
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}