import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
  public static class Pair {
    String word;
    int level;

    Pair(String _word, int _level) {
      this.word = _word;
      this.level = _level;
    }
  }

  static int findMinimumTransformations (String[] words, String startWord, String endWord) {
    Set<String> set = new HashSet<>();
    for (int i=0; i<words.length; i++) {
      set.add(words[i]);
    }

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(startWord, 1)); // Begin with the startWord with level 1
    set.remove(startWord);

    while(!q.isEmpty()) {
      Pair qf = q.remove();
      String word = qf.word;
      int level = qf.level;

      if (word.equals(endWord) == true) {
        return level;
      }

      for (int i=0; i<word.length(); i++) {

        for (char ch = 'a'; ch <= 'z'; ch++) {
          char[] replacedWordArr = word.toCharArray();
          replacedWordArr[i] = ch;
          String replacedWord = new String(replacedWordArr);
          if (set.contains(replacedWord)) {
            q.add(new Pair(replacedWord, level+1));
            set.remove(replacedWord);
          }
        }

      }
    }
    return 0;
  }
  public static void main(String[] args) {
    // String startWord = "hit";
    // String endWord = "cog";
    // String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};

    // String words[] = {"des","der","dfr","dgt","dfs"};
    // String startWord = "der";
    // String endWord = "dfs";

    String words[] = {"geek", "gefk"};
    String startWord = "gedk";
    String endWord = "geek";

    int transformations = findMinimumTransformations(words, startWord, endWord);
    System.out.println("Transformations " + transformations);
  }
}