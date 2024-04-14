import java.util.ArrayList;

public class DetectCycleDFS {
  public static class Pair {
    int val;
    int parent;

    Pair (int val, int parent) {
      this.val = val;
      this.parent = parent;
    }
  }
  // detects a cycle in the graph using DFS
  static boolean detect(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Pair graphNode) {
    visited[graphNode.val] = true;
    for (int adjacentNode : adj.get(graphNode.val)) {
      if (!visited[adjacentNode]) {
        if (detect(adj, visited, new Pair(adjacentNode, graphNode.val))) return true;
      }
      else if (adjacentNode != graphNode.val) {
        return true;
      }
    }
    return false;
  }

  // checks for connected components
  static boolean graphHasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
    for (int i=0; i< visited.length; i++) {
      if (!visited[i]) {
        boolean status = detect(adj, visited, new Pair(src, -1));
        if (status) return true;
      }
    }
    return false;
  }
  public static void main (String args[]) {
    int V = 3;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i< V+1; i++) {
      adj.add(new ArrayList<Integer>());
    }  

    adj.get(1).add(2);
    adj.get(1).add(3);

    /* adj.get(2).add(1);
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
    adj.get(7).add(6);*/

    boolean visited[] = new boolean[V+1];

    boolean result = graphHasCycle(adj, visited, 1);
    System.out.println("Graph has cycle: "+ result);
  }
}
