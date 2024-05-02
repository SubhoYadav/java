import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
  public static class Pair {
    int distance;
    int node;

    Pair (int _distance, int _node) {
      this.distance = _distance;
      this.node = _node;
    }
  }
  public static void main(String[] args) {
    int V = 5;
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
    
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(/*comparator*/ (x, y) -> x.distance - y.distance);

  }
}
