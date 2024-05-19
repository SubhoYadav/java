public class KadanesAlgo {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max = Integer.MIN_VALUE;
        // brute solution
        // for (int i=0; i<arr.length; i++) {
        //     for (int j=i; j<arr.length; j++) {
        //         int sum = 0;
        //         for (int k=i; k<=j; k++) {
        //             sum += arr[k];
        //         }
        //         max = Math.max(max, sum);
        //     }
        // }
        // System.out.println("Max subarray sum = " + max);

        // better
        // for (int i=0; i<arr.length; i++) {
        //     int sum = 0;
        //     for (int j=i; j<arr.length; j++) {
        //         sum += arr[j];
        //         max = Math.max(max, sum);
        //     }
        // }
        // System.out.println("Max subarray sum = " + max); 

        // optimal kadane's algo
        max = Integer.MIN_VALUE;
        int sum = 0, start = 0, ansStart = -1, ansEnd = -1;
        for (int i=0; i<arr.length; i++) {
            if (sum == 0) {
                // every time sum=0, we are starting off with a new subarray
                start = i;
            }
            sum += arr[i];

            if (sum < 0) {
                sum = 0;
                // No use of carrying a -ve sum cause it will only reduce the max sum
            }
            if (sum > max) {
                max = sum;
                // since we got a maximum sum, store the range of the subarray
                ansEnd = i;
                ansStart = start;
            }
        }
        System.out.println("Max subarray sum = " + max);
        for (int i=ansStart; i<=ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
