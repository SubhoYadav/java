public class LowerBound {
    static int lowerBound(int[] a, int k) {
            int low = 0, high = a.length - 1;
            int ans = a.length; 
            // If no lower bound exists, then the hypothetical index will be the lower bound
            while (low < high) {
                int mid = (low + high) / 2;
                if (a[mid] >= k) {
                    // save the index in ans cause this might be my answer and continue the search in the left half cause we need to find the smallest possible index viz a[i] >=k
                    ans = mid;
                    high = mid - 1;
                }
                else {
                    // If a[mid] < k, all the elements in the left subarray cannot be my ans, hence, continue search in the right subarray
                    low = mid + 1; 
                }
            }
            return ans;
        }
            public static void main(String args[]) {
                int arr[] = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
                int lb = lowerBound(arr, 12);
                System.out.println("Result = " + lb);
        }
}