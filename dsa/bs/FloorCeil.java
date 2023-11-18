public class FloorCeil {
    static int floor(int[] a, int k) {
    //   largest number in the array <= k
      int low = 0, high = a.length - 1, ans = -1;
      while(low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] <= k) {
            // store the number
            ans = a[mid];
            // find the largest one by going to right
            low = mid + 1;
        }
        else {
            // Go to the left because all the elements on the right will be >= k
            high = mid - 1;
        }
      }
      return ans;
    }

    static int ceil(int[] a, int k) {
        // smallest no. in the array >= k
        int low = 0, high = a.length - 1, ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] >= k) {
                ans = a[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String a[]) {
      int arr[] = {10, 20, 30, 40, 50};
      int floor = floor(arr, 25);
      int ceil = ceil(arr, 25);
      System.out.println("Floor = " + floor);
      System.out.println("Ceil = " + ceil);
    }
}