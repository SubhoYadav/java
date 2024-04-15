import java.util.ArrayList;

public class BipartiteDFS {

  static boolean check(int start, ArrayList<ArrayList<Integer>> adj, int[] color, int parentColor) {
    color[start] = 1 - parentColor;

    for (int i: adj.get(start)) {
      if (color[i] == -1) {
        if (check(i, adj, color, color[start]) == false) return false;

        else if (color[i] == parentColor) return false;
      }
    }
    return true;
  }
  public static void main(String args[]) {
    int BV = 6, NBV = 8;
    ArrayList<ArrayList<Integer>> bipartiteGraph = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> nonBipartiteGraph = new ArrayList<ArrayList<Integer>>();

    for (int i=0; i<BV+1; i++) {
      bipartiteGraph.add(new ArrayList<Integer>());
    }

    for (int i=0; i<NBV+1; i++) {
      nonBipartiteGraph.add(new ArrayList<Integer>());
    }

    // Non Bipartite graph
    nonBipartiteGraph.get(1).add(2);

    nonBipartiteGraph.get(2).add(3);
    nonBipartiteGraph.get(2).add(6);

    nonBipartiteGraph.get(3).add(2);
    nonBipartiteGraph.get(3).add(4);

    nonBipartiteGraph.get(4).add(3);
    nonBipartiteGraph.get(4).add(5);
    nonBipartiteGraph.get(4).add(7);

    nonBipartiteGraph.get(5).add(4);
    nonBipartiteGraph.get(5).add(6);

    nonBipartiteGraph.get(6).add(2);
    nonBipartiteGraph.get(6).add(5);

    nonBipartiteGraph.get(7).add(4);
    nonBipartiteGraph.get(7).add(8);

    nonBipartiteGraph.get(8).add(7);

    // Bipartite graph
    bipartiteGraph.get(1).add(2);

    bipartiteGraph.get(2).add(3);
    bipartiteGraph.get(2).add(5);

    bipartiteGraph.get(3).add(2);
    bipartiteGraph.get(3).add(4);

    bipartiteGraph.get(4).add(3);
    bipartiteGraph.get(4).add(5);
    bipartiteGraph.get(4).add(6);

    bipartiteGraph.get(5).add(2);
    bipartiteGraph.get(5).add(4);

    bipartiteGraph.get(6).add(4);
    
    int isBipartite = -1;

    // Bipartite check
    int color[] = new int[BV + 1];
    for (int i=1; i<BV+1; i++) {
      color[i] = -1; // no color initially
    }
    for (int i=1; i<BV+1; i++) {
      if (color[i] == -1) {
        if (!check(i, bipartiteGraph, color, color[i])) {
          isBipartite = 0;
          break;
        }
      }
    }

    // Non Bipartite check
    // int color[] = new int[NBV + 1];
    // for (int i=1; i<NBV+1; i++) {
    //   color[i] = -1; // no color initially
    // }
    // for (int i=1; i<NBV+1; i++) {
    //   if (color[i] == -1) {
    //     if (!check(i, nonBipartiteGraph, color, -1)) {
    //       isBipartite = 0;
    //       break;
    //     }
    //   }
    // }

    if (isBipartite == 0) {
      System.out.println("Not a Bipartite graph");
    }
    else {
      System.out.println("Bipartite graph");
    }
  } 
}
