import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.Painter;

public class ShortestPathUndirectedBfs {
  public static class Pair {
    int node;
    int dist;

    Pair(int _node, int _dist) {
      this.node = _node;
      this.dist = _dist;
    }
  }
  public static void main(String[] args) {
    int V = 9;
    int start = 0;
    // The graph has unit weights, so no Pair this time
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(0).add(1);
    adj.get(0).add(3);

    adj.get(1).add(2);
    adj.get(1).add(3);

    adj.get(2).add(6);

    adj.get(3).add(1);
    adj.get(3).add(4);
    adj.get(3).add(0);

    adj.get(4).add(3);
    adj.get(4).add(5);

    adj.get(5).add(4);
    adj.get(5).add(6);

    adj.get(6).add(5);
    adj.get(6).add(8);
    adj.get(6).add(2);
    adj.get(6).add(7);

    adj.get(7).add(6);
    adj.get(7).add(8);

    adj.get(8).add(7);
    adj.get(8).add(6);

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(start, 0));

    int[] distance = new int[V];
    for (int i=0; i<V; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    while(!q.isEmpty()) {
      Pair n = q.remove();
      for (int adjNode : adj.get(n.node)) {
        int dist = n.dist + 1;
        q.add(new Pair(adjNode, dist));
        System.out.println(q);
      }
      if (n.dist < distance[n.node]) {
        distance[n.node] = n.dist;
      }
    }

    System.out.println("Distance ");
    for (int i=0; i<V; i++) {
      System.out.print(distance[i] + " ");
    }
    System.out.println();
  }
}
