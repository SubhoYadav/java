public class MarkX {
  static void dfs (char[][] matrix, boolean[][] visited, int sr, int sc) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    visited[sr][sc] = true;
    int[] delRow = {-1,1,0,0};
    int[] delCol = {0,0,1,-1};

    for (int i=0; i<4;i++) {
      int nrow = sr + delRow[i];
      int ncol = sc + delCol[i];

      if (nrow >=0 && nrow < rows && ncol >= 0 && ncol < cols && 
      !visited[nrow][ncol] && matrix[nrow][ncol] == 'O') {
        dfs(matrix, visited, nrow, ncol);
      }
    }
  }

  static void mark (char[][] matrix, int rows, int cols) {
    boolean visited[][] = new boolean[rows][cols];

    // rows
    for (int c = 0; c < cols; c++) {
      // first row
      if (matrix[0][c] == 'O' && !visited[0][c]) {
        dfs(matrix, visited, 0, c);        
      }

      // last row
      if (matrix[rows-1][c] == 'O' && !visited[rows-1][c]) {
        dfs(matrix, visited, rows - 1, c);        
      }
    }

    // cols
    for (int r = 0; r < rows; r++) {
      // first col
      if (matrix[r][0] == 'O' && !visited[r][0]) {
        dfs(matrix, visited, 0, r);        
      }

      // last col
      if (matrix[r][cols - 1] == 'O' && !visited[r][cols - 1]) {
        dfs(matrix, visited, r, cols - 1);        
      }
    }
    
    for(int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (matrix[i][j] == 'O' && !visited[i][j]) { // not visited by a boundary 'O'
          matrix[i][j] = 'X';
        }
      }
    }
  }
  public static void main (String args[]) {
    char matrix[][] = {
      {'X','X','X','X','X'},
      {'X','O','O','X','O'},
      {'X','X','O','X','O'},
      {'X','O','X','O','X'},
      {'O','O','X','X','X'},
    };

    int rows = matrix.length;
    int cols = matrix[0].length;

    mark(matrix, rows, cols);

    for(int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  } 
}
