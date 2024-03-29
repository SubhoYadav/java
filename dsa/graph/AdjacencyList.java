import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    System.out.println("Nodes, Edges");

    int n = sc.nextInt();
    int m = sc.nextInt();

    for(int i=0; i<n+1; i++) {
      adj.add(new ArrayList<Integer>());
    }
    
    for(int i=0; i<m; i++) {
      System.out.println("U V");
      int u = sc.nextInt();
      int v = sc.nextInt();

      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    System.out.println("Adjacency List =>");
    for(int i=0; i<adj.size(); i++) {
      System.out.print(i + " => ");
      for(int j=0; j<adj.get(i).size(); j++) {
        System.out.print(adj.get(i).get(j) + " , ");
      }
      System.out.println(); 
    }
  }  
}
