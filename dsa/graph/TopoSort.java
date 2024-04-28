import java.util.ArrayList;
import java.util.Stack;
// Using DFS
// Topological sort is only valid in case of DAG
/**
 Algorithm:
 => push the node into the stack once its dfs is completed
 */
public class TopoSort {
  static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stck) {
    visited[start] = true;
    for (int adjNode : adj.get(start)) {
      if (!visited[adjNode]) {
        dfs(adjNode, adj, visited, stck);
      }
    }
    stck.push(start);
  }
  public static void main(String[] args) {
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    Stack<Integer> stck = new Stack<Integer>();
    boolean[] visited = new boolean[V];
    ArrayList<Integer> topo_sort = new ArrayList<Integer>();

    adj.get(2).add(3);

    adj.get(3).add(1);

    adj.get(4).add(0);
    adj.get(4).add(1);

    adj.get(5).add(0);
    adj.get(5).add(2);

    for (int i=0; i<V; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited, stck);
      }
    }

    while(!stck.isEmpty()) {
      topo_sort.add(stck.pop());
    }
    System.out.println(topo_sort);
  }
}
