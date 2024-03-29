import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

  static ArrayList<Integer> traversal (int start_node, ArrayList<ArrayList<Integer>> adj, int n) {
    ArrayList<Integer> bfs = new ArrayList<Integer>();
    Queue<Integer> q = new LinkedList<>();
    boolean visited[] = new boolean[n+1];

    q.add(start_node);
    visited[start_node] = true;

    while(!q.isEmpty()) {
      int node = q.remove();
      bfs.add(node);

      // putting the neighbours in the queue
      for(int i: adj.get(node)) {
        if (!visited[i]) {
          q.add(i);
          visited[i] = true;
        }
      }
    }
    return bfs;
  }
  public static void main(String args[]) {
    int n = 9;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<n+1; i++) {
      adj.add(new ArrayList<Integer>());
    }
    // creating the adj list
    adj.get(1).add(2);
    adj.get(1).add(6);

    adj.get(2).add(1);
    adj.get(2).add(3);
    adj.get(2).add(4);

    adj.get(3).add(2);

    adj.get(4).add(2);
    adj.get(4).add(5);

    adj.get(5).add(4);
    adj.get(5).add(8);

    adj.get(6).add(1);
    adj.get(6).add(7);
    adj.get(6).add(9);

    adj.get(7).add(6);
    adj.get(7).add(8);

    adj.get(8).add(5);
    adj.get(8).add(7);

    adj.get(9).add(6);

    int start_node = 1;
    ArrayList<Integer> bfs = traversal(start_node, adj, n);
    System.out.println("BFS => " + bfs);
  }
}
// SC => O(3N): N for queue, N for returning BFS traversal and N for visited array
// TC => O(N) + O(2E), E= no. of edges in the graph 
