import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EventualSafeStateTopoSort {

  static ArrayList<Integer> findSafeNodes(ArrayList<ArrayList<Integer>> adj, int V) {
    ArrayList<Integer> safeNodes = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> revAdj = new ArrayList<ArrayList<Integer>>();
    for(int i=0; i<V; i++) {
      revAdj.add(new ArrayList<Integer>());
    }

    // reverse the adjacency list cause topo sort works with indegrees
    for (int i=0; i<V; i++) {
      for(int adjNode : adj.get(i)) {
        revAdj.get(adjNode).add(i);
      }
    }

    // calculate the indegrees of the reversed graph
    int indegree[] = new int[V];
    for (int i=0; i<V; i++) {
      for(int adjNode : revAdj.get(i)) {
        indegree[adjNode]++;
      }
    }

    // push the nodes with indegree 0 into a queue
    Queue<Integer> q = new LinkedList<>();
    for (int i=0; i<V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    // now begin topo sort
    while(!q.isEmpty()) {
      int node = q.remove();
      safeNodes.add(node);
      for(int adjNode : revAdj.get(node)) {
        indegree[adjNode]--;
        if (indegree[adjNode] == 0) {
          q.add(adjNode);
        }
      }
    }

    // Collections.sort(safeNodes, Collections.reverseOrder()); => sorts in descending order
    Collections.sort(safeNodes, Collections.reverseOrder()); // sorts in ascending order
    return safeNodes;
  }
  public static void main(String[] args) {
    int V = 12;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for(int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);

    adj.get(1).add(2);

    adj.get(2).add(3);
    adj.get(2).add(4);

    adj.get(3).add(4);
    adj.get(3).add(5);

    adj.get(4).add(6);

    adj.get(5).add(6);

    adj.get(6).add(7);

    adj.get(8).add(9);

    adj.get(9).add(10);

    adj.get(10).add(8);

    adj.get(11).add(9);

    ArrayList<Integer> safeNodes = findSafeNodes(adj, V);
    System.out.println("Safe nodes: " + safeNodes);
  }
}
