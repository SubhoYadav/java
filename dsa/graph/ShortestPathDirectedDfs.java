import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathDirectedDfs {
  public static class Pair {
    int node;
    int wt;

    Pair(int _node, int _wt) {
      this.node = _node;
      this.wt = _wt;
    }
  }

  static void topoSort (int start, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stck) {
    visited[start] = true;

    for (Pair adjNode : adj.get(start)) {
      if (!visited[adjNode.node]) {
        topoSort(adjNode.node, adj, visited, stck);
      }
    }

    stck.push(start);
  }
  public static void main(String[] args) {
    int V = 7;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Pair>());
    }

    // Do a toposort to ensure that if there is a path from u->v u always comes before v thereby minimizing the number of steps to be taken in order to reach a particular node from the given source node 

    adj.get(0).add(new Pair(1, 2));

    adj.get(1).add(new Pair(3, 1));

    adj.get(2).add(new Pair(3, 3));

    adj.get(4).add(new Pair(0, 3));
    adj.get(4).add(new Pair(2, 1));

    adj.get(5).add(new Pair(4, 1));

    adj.get(6).add(new Pair(4, 2));
    adj.get(6).add(new Pair(5, 3));

    // toposort using DFS
    boolean visited[] = new boolean[V];
    Stack<Integer> stck = new Stack<Integer>();

    // In order to handle components in the graph
    for (int i=V-1; i>=0; i--) {
      if (!visited[i]) {
        topoSort(i, adj, visited, stck);
      }
    }
    
    // Find the shortest distance
    int distance[] = new int[V];
    for (int i=0; i<V; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[V-1] = 0; // mark the distance to reach the src node from the src node as 0
    while(!stck.isEmpty()) {
      int node = stck.pop();
      for (Pair adjNode : adj.get(node)) {
        int dist = distance[node] + adjNode.wt;

        if (dist < distance[adjNode.node]) {
          distance[adjNode.node] = dist; // if there is a shorter path update the new shorter distance
        }
      }
    }

    System.out.println("Distance ");
    for (int i=0; i<V; i++) {
      System.out.print(distance[i] + " ");
    }
    System.out.println();
  }
}
