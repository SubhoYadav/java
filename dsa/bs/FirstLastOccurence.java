
public class FirstLastOccurence {
    // Via first and last occurence
    static int firstOccurence(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while     (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                high = mid - 1;
                ans = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int lastOccurence(int[] arr, int k) {
        int low = 0, high = arr.length -1;
        int ans = arr.length;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) {
                high = mid - 1;
                ans = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
      int a[] = {2,4,6,8,8,8,11,13}, k=10;
      int fo = firstOccurence(a, k);
      if (a[fo] != k || fo == a.length) {
        System.out.println("{-1, -1}");
      }
      else {
        int lo = lastOccurence(a, k);
        System.out.println("First and Last Occurence " + fo + "," + (lo - 1));
      }
    }
}