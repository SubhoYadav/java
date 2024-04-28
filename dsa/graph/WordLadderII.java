import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

  static void findSequence (String[] wordList, String startWord, String endWord, ArrayList<ArrayList<String>> ans) {
    // creating a set out of wordList for quick retrival
    Set<String> set = new HashSet<>();
    for (int i=0; i<wordList.length; i++) {
      set.add(wordList[i]);
    }

    Queue<ArrayList<String>> q = new LinkedList<>();
    ArrayList<String> al = new ArrayList<String>();
    al.add(startWord);
    q.add(al);
    int level = 0;

    ArrayList<String> usedStrings = new ArrayList<String>();
    usedStrings.add(startWord);

    while(!q.isEmpty()) {
      ArrayList<String> qf = q.remove();
      if (qf.size() > level) {
        level++;
        // removing the strings from the previous level
        for (String str : usedStrings) {
          set.remove(str);
        }
        usedStrings.clear(); // clearing the usedStrings ArrayList to store the strings in the next leve;
      }

      String lastWord = qf.get(qf.size() - 1);
      if (lastWord.equals(endWord) == true) {
        if (ans.size() == 0) {
          ans.add(qf);
        }
        else if (ans.get(0).size() == qf.size()) {
          ans.add(qf);
        }
      }

      // generate seq
      for (int i=0; i<lastWord.length(); i++) {
       // since java works with references we have to we have to build the seq with a new al everytime 
       ArrayList<String> seq = new ArrayList<String>();
       for (String str : qf) {
        seq.add(str);
       }

       for (char ch='a'; ch<='z'; ch++) {
        char[] replacedWordArr = lastWord.toCharArray();
        replacedWordArr[i] = ch;
        String replacedWord = new String(replacedWordArr);

        if (set.contains(replacedWord)) {
          seq.add(replacedWord);
          usedStrings.add(replacedWord);
          q.add(seq);
        }
       }
      }

    }
  }
  public static void main(String[] args) {
    String wordList[] = {"pat", "bot", "pot", "poz", "coz"};
    String startWord = "bat";
    String endWord = "coz";

    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();

    findSequence(wordList, startWord, endWord, ans);
    System.out.println(ans);
  }
}
