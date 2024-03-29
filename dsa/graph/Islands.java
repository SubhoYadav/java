public class Islands {
  public static void main(String args[]) {
    int grid[][] = {
      {0,5,6,8},
      {0,1,7,4},
      {0,2,98,75},
      {0,0,0,0}
    };
    int row = 1, col = 2;
    for(int delrow=-1; delrow <=1; delrow++) {
      for(int delcol=-1; delcol <=1; delcol++) {
        System.out.println(grid[row+delrow][col+delcol]);
      }
    }
  }
}
