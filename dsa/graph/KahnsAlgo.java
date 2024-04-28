import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sort using BFS, again valid only for DAG
public class KahnsAlgo {
  static void algo(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    ArrayList<Integer> topo_sort = new ArrayList<Integer>();

    // Calculate the indegrees first
    for (int i=0; i<V; i++) {
      for (int adjNode : adj.get(i)) {
        indegree[adjNode]++;
      }
    }
    Queue<Integer> q = new LinkedList<>();

    // To begin with insert the nodes with indegree 0 into the queue
    for (int i=0; i<indegree.length; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    System.out.println(q);
    while (!q.isEmpty()) {
      int node = q.remove();
      topo_sort.add(node);
      for (int adjNode : adj.get(node)) {
        indegree[adjNode]--;  // reduce the indegrees of the adjacent node to the node having indegree 0
        if (indegree[adjNode] == 0) { // if indegree becomes 0 push that to the queue
          q.add(adjNode);
        }
      }
    }
    System.out.println("Topological sort " + topo_sort);
  }
  public static void main(String[] args) {
    int V = 6;
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

    algo(V, adj);
  }
}
