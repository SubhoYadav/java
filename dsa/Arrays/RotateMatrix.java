// MAKING NOTES DONE
public class RotateMatrix {
    static int[][] brute(int[][] matrix, int m, int n) {
        int[][] ans = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        return ans;
    }

    static void reverseRow (int[][] matrix, int rowNo, int col) {
        int start = 0, end = col -1;

        while(start <= end) {
            int t = matrix[rowNo][start];
            matrix[rowNo][start] = matrix[rowNo][end];
            matrix[rowNo][end] = t;

            start++;
            end--;
        }
    }
    static int[][] optimal (int[][] matrix, int m, int n) {
        // Transposing the matrix
        for (int i=0; i<m-1; i++) { 
            for (int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reversing the rows of the transposed matrix
        for (int i=0; i<m; i++) {
            reverseRow(matrix, i, n);
        }

        return matrix;
    }

    public static void main(String args[]) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int m = matrix.length, n = matrix[0].length;
        // int[][] ans = brute(matrix, m, n);
        int[][] ans = optimal(matrix, m, n);
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
