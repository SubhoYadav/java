import java.util.ArrayList;

public class DetectCycleDirected {
  static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
    visited[node] = true;
    pathVisited[node] = true;

    for (int adjNode: adj.get(node)) {
      if (!visited[adjNode]) {
        if (dfs(adjNode, adj, visited, pathVisited)) return true;
      }
      else if (pathVisited[adjNode]) {
        return true;
      }
    }
    pathVisited[node] = false;
    return false;
  }
  static boolean detect() {
    int V = 10;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<V+1; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(1).add(2);

    adj.get(2).add(3);

    adj.get(3).add(4);
    adj.get(3).add(7);

    adj.get(4).add(5);

    /*adj.get(5).add(6);

    adj.get(7).add(5);

    adj.get(8).add(9);
    adj.get(8).add(2);

    adj.get(9).add(10);
    adj.get(10).add(8); */





    boolean[] visited = new boolean[V+1];
    boolean[] pathVisited = new boolean[V+1];

    for (int i=1; i<V+1; i++) {
      if (!visited[i]) {
        if (dfs(i, adj, visited, pathVisited)) {
          return true;
        }
      }
    }
    return false;
  }
  public static void main(String args[]) {
    boolean result = detect();
    System.out.println("Result " + result);
  }
}
