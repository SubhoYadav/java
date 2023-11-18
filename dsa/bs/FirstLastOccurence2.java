public class FirstLastOccurence2 {
    static int fo(int[] a, int k) {
        int low = 0, high = a.length - 1;
        int ans = -1;
        while          (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == k) {
                ans = mid;
                high = mid - 1;
            }
            else if (a[mid] < k) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    static int lo(int[] a, int k) {
        int low = 0, ans =-1, high = a.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == k) {
                ans = mid;
                low = mid + 1;
            }
            else if(a[mid] > k) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public static void main(String args[]) {
     int a[] = {2,4,6,8,8,11,13}, k = 10;
     int fo = fo(a, k);
     if (fo != -1) {
        int lo = lo(a, k);
        System.out.println("First and last occurence " + fo + " , " + lo);
     }
     else {
        System.out.println("{ -1, -1 }");
     }
    }
}