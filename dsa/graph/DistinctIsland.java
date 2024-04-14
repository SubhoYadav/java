import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DistinctIsland {
    static void dfs(int[][] grid, boolean[][] visited, int sr, int sc, int rows, int cols, int br, int bc, ArrayList<String> arrayList) {
        visited[sr][sc] = true;
        System.out.println("AL " + " " + Math.abs(sr - br) + "" + Math.abs(sc - bc));
        arrayList.add(String.format("(%d, %d)", Math.abs(sr - br), Math.abs(sc - bc)));
        
        int[] delRow = {-1, 1,0,0};
        int[] delCol = {0,0,1,-1};

        for (int i=0; i<4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];

            if (nrow >=0 && nrow <rows && ncol >=0 && ncol <cols && grid[nrow][ncol] == 1 && !visited[nrow][ncol]) {
              dfs(grid, visited, nrow, ncol, br, bc, rows, cols, arrayList);
            }
        }
     }
    public static void main(String[] args) {
        int [][] grid = {
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,1,1},
            {1,1,0,1,0}
        };

        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][] = new boolean[rows][cols];
        Set<String> set = new HashSet<>();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    dfs(grid, visited, i, j, i, j, rows, cols, arrayList);
                    set.add(String.join("", arrayList));
                }
            }
        }
        System.out.println(set);
        System.out.println("Distinct islands: " + set.size());
    }
}