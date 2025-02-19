import java.util.*;

public class SpiralTraversal {
    static ArrayList<Integer> solve (int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
        
            // left-right
            for (int i=left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // top-bottom
            for (int i=top; i<=bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // right-left
            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom-top
            if (left <= right) {
                for (int i=bottom; i>=top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4,5,6},
            {20,21,22,23,24,7},
            {19,32,33,34,25,8},
            {18,31,36,35,26,9},
            {17,30,29,28,27,10},
            {16,15,14,13,12,11}
        };

        ArrayList<Integer> traversal = solve(matrix);
        System.out.println(traversal);
    }
}
