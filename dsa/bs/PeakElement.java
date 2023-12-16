// Given an array find the index of the peak element 
/*
 * PEAK ELEMENT: If i is the index of the peak element, the following condition will be met: a[i-1] < a[i] > a[i+1]
 * 
 * INTUITION: 
 * If you are on the uphill the peak element will be on the right a[mid] < a[mid+1]
 * If you are on the downhill the peak element will be on left a[mid] > a[mid+1]
 * 
 * THE VALEY CASE: [1,5,1,2,1] and mid = 2 , eliminating eiether of the slopes will find you a peak element cause there are multiple peaks
 */
public class PeakElement {

  static int find(int [] a, int n) {
    // Again, in order to avoid wriring a lot of edge cases I will trim down the search space and handle the corner cases separately
    if (a[0] > a[1]) return a[0];
    if (a[n-1] > a[n-2]) return a[n-1];

    int low = 1, high = n-2;

    while(low <= high) {
      int mid = (low + high) / 2;

      // check whether the mid element is the peak or not
      if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
        return mid;
      }
      // checking for downhill
      else if (a[mid] > a[mid + 1]) high = mid -1; // go left
      else low = mid + 1;
    }
    return -1; 
  }

  public static void main(String a[]) {
    int arr[] = {1,8,1,5,3};
    int result = find(arr, arr.length);
    System.out.println("Result = " + result);
  }
}
