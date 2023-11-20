public class PassBy {
  int x = 12;
  void passByValue(int a) {
    x = a;
  }
  void passByReference(PassBy p) {
    p.x = 45;
  }
  public static void main(String args []) {
    PassBy variable = new PassBy();
    System.out.println(variable.x);
    variable.passByValue(18);
    variable.passByReference(variable);
    System.out.println(variable.x);

  }
}
