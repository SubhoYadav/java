import java.util.ArrayList;

public class SafeState {
  // true => cycle is present, false if cycle is not present
  static boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, boolean[] check) {
    check[start] = false;
    visited[start] = true;
    pathVisited[start] = true;

    for (int adjNode : adj.get(start)) {
      if (!visited[adjNode]) {
        if (dfs(adjNode, adj, visited, pathVisited, check)) return true;
      }
      else if (pathVisited[adjNode]) return true;
    }
    check[start] = true;
    pathVisited[start] = false;
    return false;
  }

  public static void main(String[] args) {
    int V = 7; // 0 based indexing
    boolean[] visited = new boolean[V];
    boolean[] pathVisited = new boolean[V];
    boolean[] check = new boolean[V];
    ArrayList<Integer> safe_nodes = new ArrayList<Integer>();

    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);
    adj.get(0).add(2);

    adj.get(1).add(3);
    adj.get(1).add(2);

    adj.get(2).add(5);

    adj.get(3).add(0);

    adj.get(4).add(5);

    for (int i=0; i<V; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited, pathVisited, check);
      }
    }
    
    for (int i=0; i<V; i++) {
      if (check[i]) {
        safe_nodes.add(i);
      }
    }
    System.out.println(safe_nodes);
  }
}
