import java.util.*;

// TC: E logV

// Dijkastra's algo do not work for:
// graphs having negative weights
// graphs having negative weight cycles
public class DijkstraAlgo {
  public static class Pair {
    int distance;
    int node;

    Pair (int _distance, int _node) {
      this.distance = _distance;
      this.node = _node;
    }
  }

  // Implements dijkstra's algorithm using priority queue
  static int[] solve(ArrayList<ArrayList<Pair>> adj, int src, int V) {
    int[] distance = new int[V]; // 0 based indexing of nodes
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(/*comparator*/ (x, y) -> x.distance - y.distance);

    for (int i=0; i<distance.length; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[src] = 0;

    pq.add(new Pair(0,0));

    while(pq.size() != 0) {
      Pair pqTop = pq.remove();
      int startDist = pqTop.distance;

      for (Pair p: adj.get(pqTop.node)) {
        if (p.distance + startDist < distance[p.node]) {
          distance[p.node] = p.distance + startDist;
          pq.add(new Pair(distance[p.node], p.node));
        }
      }
    }
    return distance; 
  }
  
  // Implements dijkstra's algorithm using set
  static int[] solve2(ArrayList<ArrayList<Pair>> adj, int src, int V) {
    int[] distance = new int[V];
    for (int i=0; i<distance.length; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    Set<Pair> set = new HashSet<>(); // stores (distance, node) pairs

    set.add(new Pair(0, src));
    distance[src] = 0;

    while(!set.isEmpty()) {
      Iterator<Pair> it = set.iterator();
      if (it.hasNext()) {
        Pair node = it.next();
        set.remove(node);

        int initialDistance = distance[node.node];
        for (Pair it1: adj.get(node.node)) {
          if ((it1.distance + initialDistance) < distance[it1.node]) {
            if (distance[it1.node] != Integer.MAX_VALUE) {
              // If the distance is not -1, it means someone previosly has reached that node and in order to save iterations, remove that node from the set.
              set.remove(new Pair(distance[node.node], node.node));
            }

            distance[it1.node] = it1.distance + initialDistance;
            set.add(new Pair(distance[it1.node], it1.node));
          }
        }
      }
    }

    return distance;
  }
  public static void main(String[] args) {
    int V = 6;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Pair>());
    }

    adj.get(0).add(new Pair(4, 1));
    adj.get(0).add(new Pair(4, 2));

    adj.get(1).add(new Pair(4, 0));
    adj.get(1).add(new Pair(2, 2));
    
    adj.get(2).add(new Pair(4, 0));
    adj.get(2).add(new Pair(2, 1));
    adj.get(2).add(new Pair(3, 3));
    adj.get(2).add(new Pair(1, 4));
    adj.get(2).add(new Pair(6, 5));

    adj.get(3).add(new Pair(3, 2));
    adj.get(3).add(new Pair(2, 5));

    adj.get(4).add(new Pair(1, 2));
    adj.get(4).add(new Pair(3, 5));

    adj.get(5).add(new Pair(2, 3));
    adj.get(5).add(new Pair(6, 2));
    adj.get(5).add(new Pair(3, 4));
    
    // int [] dist = solve(adj, 0, 6);
    int [] dist = solve2(adj, 0, 6);

    for (int i=0; i<dist.length; i++) {
      System.out.println(dist[i] + " ");
    }
  }
}

