public class StringOps {
  public static void main(String[] args) {
    String str = "Subho";
    char originalChar = str.charAt(0);

    char[] replacedCharacterArr = str.toCharArray();
    replacedCharacterArr[0] = 'Y';
    String replacedWord = new String(replacedCharacterArr);
    System.out.println(replacedWord);

    System.out.println("subho" == "subho");

  }
}
