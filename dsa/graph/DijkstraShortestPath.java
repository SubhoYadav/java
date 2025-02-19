import java.util.*;

class Pair {
    int val;
    int distance;
    Pair(int _val, int _distance) {
        this.val = _val;
        this.distance = _distance;
    }
}
public class DijkstraShortestPath {
    static ArrayList<Integer> findShortestPath(ArrayList<ArrayList<Pair>> adj, int src, int dest, int V) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int distance[] = new int[V+1];
        for (int i=0; i<distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int parent[] = new int[V+1];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        // Priority queue is nothing but a min heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(src, 0));
        distance[src] = 0;

        while(pq.size() != 0) {
            Pair pqTop = pq.remove();
            int initialDistance = pqTop.distance;

            for(Pair it: adj.get(pqTop.val)) {
                if (it.distance + initialDistance < distance[it.val]) {
                    pq.add(new Pair(it.val, it.distance + initialDistance));
                    distance[it.val] =  it.distance + initialDistance;
                    parent[it.val] = pqTop.val;
                }
            }
        }
        int itr = dest;

        while (parent[itr] != itr) {
            ans.add(itr);
            itr = parent[itr];
        }
        ans.add(itr);

        ArrayList<Integer> revAns = new ArrayList<Integer>();
        for (int i = ans.size() -1; i>=0; i--) {
            revAns.add(ans.get(i));
        }
        return revAns;
    }
    public static void main(String[] args) {
        int V = 5; 
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i=0; i<V+1; i++) {
            adj.add(new ArrayList<Pair>());
        }

        adj.get(1).add(new Pair(2,2));
        adj.get(1).add(new Pair(4,1));

        adj.get(2).add(new Pair(3,4));
        adj.get(2).add(new Pair(5,5));
        adj.get(2).add(new Pair(1,2));

        adj.get(3).add(new Pair(2,4));
        adj.get(3).add(new Pair(5,1));
        adj.get(3).add(new Pair(4,3));

        adj.get(4).add(new Pair(3,3));
        adj.get(4).add(new Pair(1,1));

        adj.get(5).add(new Pair(3,1));
        adj.get(5).add(new Pair(2,5));

        System.out.println(findShortestPath(adj, 1, V, V));
    }
}