import java.util.Scanner;

public class AdjacencyMatrix {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Nodes, Edges");
    int n = sc.nextInt();
    int m = sc.nextInt();

    int adj[][] = new int[n+1][n+1]; // for 1 based indexed graphs
    for (int i=0; i<(n+1); i++) {
      for (int j=0; j<(n+1); j++) {
        adj[i][j] = 0;
      }
    }

    for (int i=0; i<m; i++) {
      System.out.println("U, V");
      int u = sc.nextInt();
      int v = sc.nextInt();

      adj[u][v] = 1;
      adj[v][u] = 1;
    }
    System.out.println("Adjacency matrix");
    for (int i=0; i<(n+1); i++) {
      for (int j=0; j<(n+1); j++) {
        System.out.print(adj[i][j] + " ");
      }
      System.out.println();
    }
  }
}
