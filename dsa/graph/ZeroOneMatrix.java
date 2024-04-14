import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
  public static class Triplet {
    int row,col, step;
    Triplet (int _row, int _col, int _step) {
      this.row = _row;
      this.col = _col;
      this.step = _step;
    }
  }

  static void findDistance(int[][] grid, boolean[][] visited, int[][] distance, int rows, int cols) {
    Queue<Triplet> q = new LinkedList<>();
    int[] delRow = {-1,1,0,0};
    int[] delCol = {0,0,1,-1};

    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[i].length; j++) {
        if (grid[i][j] == 1) {
          visited[i][j] = true;
          q.add(new Triplet(i, j, 0));
        }
      }
    }

    while(!q.isEmpty()) {
      Triplet node = q.remove();
      distance[node.row][node.col] = node.step;
      
      for (int i=0; i<4; i++) {
        int newr = node.row + delRow[i];
        int newc = node.col + delCol[i];

        if (newr >= 0 && newr < rows && newc >=0 && newc < cols && !visited[newr][newc]) {
          q.add(new Triplet(newr, newc, node.step + 1));
          visited[newr][newc] = true;
        }
      }
    }
  }
  public static void main(String args[]) {
    int grid[][] = {
      {1,0,1},
      {1,1,0},
      {1,0,0}
    };

    int rows = grid.length;
    int cols = grid[0].length;

    boolean visited[][] = new boolean[rows][cols];
    int distance[][] = new int[rows][cols];

    findDistance(grid, visited, distance, rows, cols);

    for (int i=0; i<distance.length; i++) {
      for(int j=0; j<distance[i].length; j++) {
        System.out.print(distance[i][j] + " ");
      }
      System.out.println();
    }
  }
}