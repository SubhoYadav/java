import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule {
  
  public static class Pair {
    int first;
    int second;
    Pair(int _first, int _second) {
      this.first = _first;
      this.second = _second;
    }
  }

  static void dfs (int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stck) {
    visited[start] = true;
    for (int adjNode : adj.get(start)) {
      if (!visited[adjNode]) {
        dfs(adjNode, adj, visited, stck);
      }
    }
    stck.push(start);
  }
  
  static boolean isPossible(ArrayList<Pair> pairList) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    // How many edges will be there ?
    // pairList.length ! exactly 3 edged in this case 1->0, 2->1 and 3->2
    int V = pairList.size();

    for (int i=0; i<V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    for (Pair p : pairList) {
      adj.get(p.first).add(p.second);
    }
    
    // Topological sort using dfs
    ArrayList<Integer> topo_sort = new ArrayList<Integer>();
    boolean visited[] = new boolean[V];
    Stack<Integer> stck = new Stack<Integer>();

    for (int i=0; i<V; i++) {
      if (!visited[i]) {
        dfs(i, adj, visited, stck);
      }
    }
    while(!stck.isEmpty()) {
      topo_sort.add(stck.pop());
    }
    if (topo_sort.size() == V) { 
      return true;
    }
    else {
      return false;
    }
  }

  public static void main(String[] args) {
    ArrayList<Pair> pairList = new ArrayList<Pair>();
    
    // pairList.add(new Pair(1,0));
    // pairList.add(new Pair(2,1));
    // pairList.add(new Pair(3,2));

    pairList.add(new Pair(1,0));
    pairList.add(new Pair(0,1));

    boolean result = isPossible(pairList);
    System.out.println("Is task possible ? " + result);
  }
}
