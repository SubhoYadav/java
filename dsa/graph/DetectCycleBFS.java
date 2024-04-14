import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {

  public static class Pair {
    int val;
    int parent;

    Pair(int val, int parent) {
      this.val = val;
      this.parent = parent;
    }
  }

  // detects a cycle using bfs algorithm
  static boolean detect (ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
    Queue<Pair> q = new LinkedList<>();

    q.add(new Pair(src, -1));
    visited[src] = true;

    while(!q.isEmpty()) {
      Pair node = q.remove();
      for (int adjacentNode : adj.get(node.val)) {
        if (!visited[adjacentNode]) {
          visited[adjacentNode] = true;
          q.add(new Pair(adjacentNode, node.val));
        }
        else if (adjacentNode != node.parent) {
          return true; // graph has a cycle
        }
      }
    }
    return false;
  }

  // returns whether graph has a cycle or not
  static boolean graphHasCycle (ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        boolean status = detect(adj, visited, src);
        if (status) return true;
      }
    }
    return false;
  }
  public static void main (String args[]) {
    int V = 7;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i< V+1; i++) {
      adj.add(new ArrayList<Integer>());
    }  

    adj.get(1).add(2);
    adj.get(1).add(3);

    adj.get(2).add(1);
    adj.get(2).add(5);

    adj.get(3).add(1);
    adj.get(3).add(6);
    adj.get(3).add(4);

    adj.get(4).add(3);

    adj.get(5).add(2);
    adj.get(5).add(7);

    adj.get(6).add(3);
    adj.get(6).add(7);

    adj.get(7).add(5);
    adj.get(7).add(6);

    boolean visited[] = new boolean[V+1];

    boolean result = graphHasCycle(adj, visited, 1);
    System.out.println("Graph has cycle: " + result);
  }
}
