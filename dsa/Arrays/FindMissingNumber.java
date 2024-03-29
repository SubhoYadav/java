public class FindMissingNumber {
  static long solve(int[] arr, int n) {
    // will utilise the formula n*(n+1) / 2 which is the formula for sum of first n natural numbers
    long sumOfNaturalNumbers = (n*(n+1))/ 2;
    long sumOfArr = 0;
    for(int i=0; i<arr.length; i++) {
      sumOfArr += arr[i];
    }
    return (sumOfNaturalNumbers - sumOfArr);
  }
  static int solveOptimal(int[] arr, int n) {
    // Will leverage the XOR property
    // a ^ a = 0
    // 0 ^ a = a
    // 0 ^ 0 = 0

    // 1 ^ 2 ^ 3 ^ 4 ^ 5
    // 1 ^ 2 ^   ^ 4 ^ 5
    // 0 ^ 0 ^ 3 ^ 0 ^ 0
    // 3
    int xor1 = 0;
    int xor2 = 0;
    n = n -1;
    for (int i = 0; i< n; i++) {
      xor1 = xor1 ^ i+1;
      xor2 = xor2 ^ arr[i];
    }
    xor1 = xor1 ^ (n + 1);
    System.out.println("XX" + xor1 + " " + xor2);
    // return (xor1 ^ xor2);
    return (xor2 ^ xor1);
  }
  public static void main(String args[]) {
    int[] arr = {1,2,4,5};
    long result = solve(arr, 5);
    System.out.println("Result = " + result);

    int resultOptimal = solveOptimal(arr, 5);
    System.out.println("Result optimal = " + resultOptimal);
  }
}
