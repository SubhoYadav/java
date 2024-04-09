public class FloodFill {
  private static void dfs(int[][] image, int ans[][], int sr, int sc, int[] deltaRow, int[] deltaCol, int startColor, int newColor, int rows, int cols) {
    ans[sr][sc] = newColor;

    for(int i=0; i < 4; i++) {
      int newRow = sr + deltaRow[i];
      int newCol = sc + deltaCol[i];
      
      if (
        newRow >= 0 && newRow < rows &&
        newCol >= 0 && newCol < cols &&
        image[newRow][newCol] == startColor &&
        ans[newRow][newCol] != newColor
      ) {
        dfs(image, ans, newRow, newCol, deltaRow, deltaCol, startColor, newColor, rows, cols);
      }
    }
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int rows = image.length;
    int cols = image[0].length;

    int ans[][] = new int[rows][cols];

    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[i].length; j++) {
        ans[i][j] = image[i][j];
      }
    }
    int deltaRow[] = {-1, 1, 0, 0};
    int deltaCol[] = {0, 0, 1, -1};
    int startColor = image[sr][sc];

    dfs(image, ans, sr, sc, deltaRow, deltaCol, startColor, newColor, rows, cols);

    return ans;
  }
  public static void main(String args[]) {
    int[][] image = {
      {1,1,1},
      {2,2,0},
      {2,2,2}
    };
    int sr = 2, sc = 2, newColor = 3;
    int[][] ans = floodFill(image, sr, sc, newColor);

    System.out.println("Flood Filled Matrix:");
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans[i].length; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
