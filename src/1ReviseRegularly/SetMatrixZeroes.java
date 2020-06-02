package Matrix;

import TopInterviewQuestions.FindIsland;

/**
 * Created by NISHANT on 2/9/18.
 *
 * https://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
 */

public class SetMatrixZeroes {

    public static void main(String[] args)
    {
        int mat[ ][ ] = { {1, 0, 0, 1},
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},
        };

        System.out.println("Matrix Intially");

        FindIsland.printMatrix(mat);
        modifyMatrix(mat);
        System.out.println("Matrix after modification n");
        FindIsland.printMatrix(mat);

    }

    private static void modifyMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        boolean[] rowzero = new boolean[rows];
        boolean[] colzero = new boolean[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    rowzero[r] = true;
                    colzero[c] = true;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            if (rowzero[r]) {
                for (int c = 0; c < cols; c++) {
                    mat[r][c] = 1;
                }
            }
        }
        for (int c = 0; c < cols; c++) {
            if (colzero[c]) {
                for (int r = 0; r < rows; r++) {
                    mat[r][c] = 1;
                }
            }
        }
    }
}
