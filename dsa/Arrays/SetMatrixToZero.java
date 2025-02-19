// MAKING NOTES DONE
import java.util.*;
import java.util.Arrays;
public class SetMatrixToZero {

    static void optimal (ArrayList<ArrayList<Integer>> matrix) {
        int col0 = 1;

        // Assuming that the matrix is a square one
        int row = matrix.size();
        int col = matrix.get(0).size();

        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                if (matrix.get(r).get(c) == 0) {
                    // MARKING THE ROW MATRIX 
                    matrix.get(r).set(0, 0);

                    // marking the col matrix
                    if (c != 0) 
                      matrix.get(0).set(c, 0);
                    else col0 = 0;
                }
            }
        }
        
        for (int r=1; r<row; r++) {
            for (int c=1; c<col; c++) {
                if (matrix.get(r).get(0) == 0 || matrix.get(0).get(c) == 0) {
                    matrix.get(r).set(c, 0);
                }  
            }
        }

        
        if (matrix.get(0).get(0) == 0) {
            for (int i=0; i<row; i++) { 
                matrix.get(0).set(i, 0);
            }
        } 
        
        if (col0 == 0) {
            for (int i=0; i<col;i++) {
                matrix.get(i).set(0,0);
            }
        }

        for (ArrayList<Integer> al : matrix) {
            System.out.println(al);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        // matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1,1})));
        // matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,0,1,1})));
        // matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,0,1})));
        // matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,1,1,1})));

        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,0,1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1})));
        
        optimal(matrix);
    }
}
