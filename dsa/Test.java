import java.util.LinkedList;
import java.util.Queue;

public class Test {
  public static void main(String args []) {
    String str = "b";
    // System.out.println("Test" + str.substring(1));

    boolean visited[] = new boolean[4];
    for (int i=0; i<visited.length; i++) {
      System.out.println(visited[i]);
    }
    Queue<Integer> q = new LinkedList<>();

    q.add(5);
    q.add(10);

    System.out.println(q.remove());
  }
}
