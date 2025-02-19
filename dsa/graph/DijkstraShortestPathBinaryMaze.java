import java.util.LinkedList;
import java.util.Queue;

/**
   In this problem we will be using the dijkstra's algo but with a queue instead of a priority queue
   because since the nodes will be connected with unit distance edges, the queue will always store the 
   distances in an increasing order ans we always get the node that is the nearest to the source node
 */
class Triplet {
    int distance;
    int row;
    int col;
    Triplet(int _distance, int _row, int _col) {
        this.distance = _distance;
        this.row = _row;
        this.col = _col;
    }
}
public class DijkstraShortestPathBinaryMaze {
    static int findShotestPath(int[][] maze, int mr, int mc, int srcRow, int srcCol, int destRow, int destCol) {
        int [][] distance = new int[mr][mc];
        for (int i=0; i< mr; i++) {
            for (int j=0; j<mc; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Triplet> q = new LinkedList<Triplet>();
        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,1,-1};

        distance[srcRow][srcCol] = 0;
        q.add(new Triplet(0, srcRow, srcCol));
        
        while(!q.isEmpty()) {
            Triplet qTop = q.remove();
            int initialDistance = qTop.distance;
            for (int k=0; k<delCol.length; k++) {
                int nrow = qTop.row + delRow[k];
                int ncol = qTop.col + delCol[k];

                if (
                    nrow >= 0 && nrow < mr &&
                    ncol >= 0 && ncol < mc &&
                    maze[nrow][ncol] == 1 &&
                    initialDistance + 1  < distance[nrow][ncol] 
                ) {
                    if (nrow == destRow && ncol == destCol) {
                        return initialDistance + 1; // reached the destination
                    }
                    q.add(new Triplet(initialDistance + 1, nrow, ncol));
                }
            }

        }

        return -1;
    }
    public static void main(String[] args) {
        int maze[][] = {
            {1,1,1,1},
            {1,1,0,1},
            {1,1,1,1},
            {1,1,0,0},
            {1,0,0,0},
        };
        System.out.println(findShotestPath(maze, 5, 4, 0, 1, 2, 2));
    }
}
