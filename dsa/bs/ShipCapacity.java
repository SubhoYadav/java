public class ShipCapacity {

  // Returns the maximum of all the elements of a
  static int max(int a[]) {
    int maximum = Integer.MIN_VALUE;

    for(int i=0; i<a.length; i++) {
      if(a[i] > maximum) maximum = a[i];
    }

    return maximum;
  }

  // Returns the sum of the elements of a
  static int sum(int a[]) {
    int sum = 0;

    for(int i=0; i<a.length; i++) {
      sum += a[i];
    }

    return sum;
  }

  // Returns the no. of days to ship all the packages for a given capacity
  static int daysReq(int a[], int capacity) {
    int load = 0, days = 1;

    for(int i=0; i<a.length; i++) {
      if(load + a[i] > capacity ) {
        days ++;
        load = a[i];
      }
      else load += a[i];
    }

    return days;
  }

  // The function that performs binary search
  static int solve (int[] a, int days) {
    int low = max(a), high = sum(a), ans = -1;

    while(low <= high) {
      int mid = (low + high) / 2;

      if(daysReq(a, mid) > days) low = mid + 1;
      else {
        high = mid - 1;
        ans = mid;
      }
    }
    return ans;
  }

  public static void main(String args[]) {
    // min capacity of ship = max(a)
    // max capacity of ship = sum(a)

    int a[] = {5, 4, 5, 2, 3, 4, 5, 6};
    int days = 5;

    int result = solve(a,days);
    System.out.println("Result =>" + result);
  }
}