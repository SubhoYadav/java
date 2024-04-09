import java.util.LinkedList;
import java.util.Queue;

class Pair {
  int first;
  int second;
  Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}

public class Islands {
  static void bfs(int[][] grid, boolean[][] visited, Pair node, int n, int m) {
    Queue<Pair> q = new LinkedList<>();
    q.add(node);
    visited[node.first][node.second] = true;

    while(!q.isEmpty()) {
      Pair front = q.remove();

      for(int delrow = -1; delrow <=1; delrow++) {
        for(int delcol = -1; delcol <=1; delcol++) {
          int r = front.first + delrow;
          int c = front.second +  delcol;

          if (r < n && r >=0 && c >= 0 && c < m && grid[r][c] == 1 && !visited[r][c]) {
            q.add(new Pair(r,c));
            visited[r][c] = true;
          }
        }
      }
    }
  }
  public static void main(String args[]) {
    int grid[][] = {
      {0,1,1,0},
      {0,1,1,0},
      {0,0,1,0},
      {0,0,0,0},
      {1,1,0,1}
    };
    int islands = 0;
    int n = grid.length, m = grid[0].length;
    boolean visited[][] = new boolean[n][m];

    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          Pair node = new Pair(i,j);
          islands++;
          bfs(grid, visited, node, n ,m);
        }
      }
    }
    System.out.println(islands);
  }
}
