import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
  public static class Triplet {
    int row;
    int col;
    int t;
    Triplet (int row, int col, int t) {
      this.row = row;
      this.col = col;
      this.t = t;
    }
  }
  static int fresh =  1, rotten = 2, empty = 0;

  static int getTimeToRot (int[][] crate) {
    int rows = crate.length, cols = crate[0].length;

    int[] deltaRow = {-1, 1, 0, 0};
    int[] deltaCol = {0, 0, 1, -1};
    int tmax = 0;

    Queue<Triplet> q = new LinkedList<>();

    for(int i = 0; i < crate.length; i++) {
      for(int j = 0; j < crate[i].length; j++) {
        if (crate[i][j] == rotten) {
          q.add(new Triplet(i, j, 0));
        }
      }
    }

    // creatig a separate matrix for rotting the oranges
    int [][] visited = new int[rows][cols]; // all cell values defaults to 0

    while(!q.isEmpty()) {
      Triplet node = q.remove();
      visited[node.row][node.col] = rotten;
      tmax = node.t;
      for (int i=0; i<4; i++) {
        int nrow = node.row + deltaRow[i];
        int ncol = node.col + deltaCol[i];
        
        if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols &&
            crate[nrow][ncol] == fresh && visited[nrow][ncol] != rotten) {
              q.add(new Triplet(nrow, ncol, node.t + 1));
        }
      }      
    }

    return tmax;
  }
  public static void main(String args[]) {
    int[][] crate = {
      {2,1,1},
      {1,1,0},
      {0,1,1}
    };

    int result = getTimeToRot(crate);
    System.out.println(result);
  }
}
