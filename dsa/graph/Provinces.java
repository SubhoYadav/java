import java.util.ArrayList;

public class Provinces {

  static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] visited) {
    visited[node] = true;

    for(int i : adj.get(node)) {
      if (!visited[i]) {
        dfs(i, adj, visited);
      }
    }
  }
  public static void main(String args[]) {
    int n = 3;
    int adj[][] = {
      {1,0,1},
      {0,1,0},
      {1,0,1}
    };
    boolean visited[] = new boolean[n+1];
    int provinces = 0;

    ArrayList<ArrayList<Integer>> adjLst = new ArrayList<ArrayList<Integer>>();
    for(int i=0; i<n+1; i++) {
      adjLst.add(new ArrayList<Integer>());
    }

    for(int i = 0; i<adj.length; i++) {
      for (int j = 0; j<adj[i].length; j++) {
        if (adj[i][j] == 1 && i != j) {
          adjLst.get(i).add(j);
          adjLst.get((j)).add(i);
        } 
      }
    }
    
    for(int node = 1; node < visited.length; node++) {
      if (!visited[node]) {
        provinces++;
        dfs(node, adjLst, visited);
      }
    }
    System.out.println(provinces);
  }
}
