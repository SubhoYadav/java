import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedII {
  static boolean detect(int V, ArrayList<ArrayList<Integer>> adj) {
    int [] indegree = new int[V];
    for (int i=0; i<V; i++) {
      for (int adjNode : adj.get(i)) {
        indegree[adjNode]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i=0; i<V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int cnt = 0;
    while(!q.isEmpty()) {
      int node = q.remove();
      cnt++;
      for (int adjNode : adj.get(node)) {
        indegree[adjNode]--;
        if (indegree[adjNode] == 0) {
          q.add(adjNode);
        }
      }
    }
    if (cnt == V) {
      return false;
    }
    else {
      return true;
    }
  }

  public static void main(String[] args) {
    int V = 6; // 1-based indexing
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(2).add(3);

    adj.get(3).add(1);

    adj.get(4).add(0);
    adj.get(4).add(1);

    adj.get(5).add(0);
    adj.get(5).add(2);

    
    boolean result = detect(V, adj);
    System.out.println("Is graph cyclic ? " + result);
  }
}
