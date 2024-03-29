import java.util.ArrayList;

public class Dfs {
  static void traversal(int start_node, ArrayList<ArrayList<Integer>>adj, boolean[] visited, ArrayList<Integer> dfs) {
    visited[start_node] = true;
    dfs.add(start_node);

    for(int i: adj.get(start_node)) {
      if (!visited[i]) {
        traversal(i, adj, visited, dfs);
      }
    }
  }
  public static void main(String args[]) {
    int n = 8, start_node = 1;
    boolean visited[] = new boolean[n+1];
    ArrayList<Integer> dfs = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    
    for (int i=0; i<n+1; i++) {
      adj.add(new ArrayList<Integer>());
    }

    adj.get(1).add(2);
    adj.get(1).add(3);

    adj.get(2).add(1);
    adj.get(2).add(5);
    adj.get(2).add(6);

    adj.get(3).add(1);
    adj.get(3).add(4);
    adj.get(3).add(7);

    adj.get(4).add(3);
    adj.get(4).add(8);

    adj.get(5).add(2);

    adj.get(6).add(2);

    adj.get(7).add(3);
    adj.get(7).add(8);

    adj.get(8).add(4);
    adj.get(8).add(7);

    traversal(start_node, adj, visited, dfs);
    System.out.println("dfs => " + dfs);
  }  
}
