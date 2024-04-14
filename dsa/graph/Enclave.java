import java.util.LinkedList;
import java.util.Queue;

public class Enclave {
  public static class Pair{
    int row;
    int col;

    Pair(int _row, int _col) {
      this.row = _row;
      this.col = _col;
    }
  }
  
  static void bfs(Queue<Pair> q, int[][] matrix, boolean[][] visited) {
    int[] delRow = {-1,1,0,0};
    int[] delCol = {0,0,1,-1};
    int rows = matrix.length;
    int cols = matrix[0].length;

    while(!q.isEmpty()) {
      Pair node = q.remove();

      for (int i=0; i<4; i++) {
        int nrow = node.row + delRow[i];
        int ncol = node.col + delCol[i];

        if (nrow >=0 && nrow < rows && ncol >= 0 && ncol < cols &&
        !visited[nrow][ncol] && matrix[nrow][ncol] == 1) {
          q.add(new Pair(nrow, ncol));
          visited[nrow][ncol] = true;
        }
      }
    }
  }
  static int countEnclaves(int [][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    boolean visited[][] = new boolean[rows][cols];
    Queue<Pair> q = new LinkedList<>();

    // rows 
    for (int c=0; c<cols; c++) {
      // first row
      if (!visited[0][c] && matrix[0][c] == 1) {
        q.add(new Pair(0, c));
        visited[0][c] = true;
      }

      // last row
      if (!visited[rows - 1][c] && matrix[rows - 1][c] == 1) {
        q.add(new Pair(rows - 1, c));
        visited[rows - 1][c] = true;
      }
    }

    // cols 
    for (int r=0; r<rows; r++) {
      // first row
      if (!visited[r][0] && matrix[r][0] == 1) {
        q.add(new Pair(r, 0));
        visited[r][0] = true;
      }

      // last row
      if (!visited[r][cols - 1] && matrix[r][cols - 1] == 1) {
        q.add(new Pair(r, cols - 1));
        visited[r][cols - 1] = true;
      }
    }

    bfs(q, matrix, visited);

    int counter = 0;
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (matrix[i][j] == 1 && !visited[i][j]) counter++;
      }
    }
    return counter;
  }
  public static void main (String args[]) {
    int matrix[][] = {
      {0,0,1,1},
      {0,1,1,0},
      {0,1,1,0},
      {0,0,0,1},
      {0,1,1,0}
    };

    int result = countEnclaves(matrix);
    System.out.println("Enclaves = " + result);
  }
}
