public class Print1toN {
  static void print(int n) { // hypothesis
    if (n == 0) return; // base case

    print(n-1); // Induction
    System.out.println(n + " "); 
  }
  // Beauty of hypothesis
  static void printRev(int n) {
    if (n == 0) return;
    System.out.println(n);
    // This function will print (n-1) to 1
    printRev(n-1);
  }

  static int factorial (int n) { // hypothesis
    if (n == 1) { // base case
      return n;
    }
    // factorial will bring me the factorial of n -1
    int x = factorial(n-1); // Induction
    // I just have to multiply n to it to get the factorial of n
    return n * x;
  }
  public static void main(String args[]) {
    int n = 5;
    // print(n);
    // printRev(n);
    int factorial = factorial(n);
    System.out.println("Factorial " + factorial);
  }
}