package Matrix;

/**
 * Created by NISHANT on 2/14/18.
 */
public class FindIsland {

    public static void main(String[] args) {

        int count = 0;
        int mat[ ][ ] = {
                {0, 1, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        System.out.println("Matrix Intially");
        printMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1){
                    count += walkMore(mat, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static int walkMore(int[][] mat, int i, int j) {
        if (mat[i][j] == 1) {
            mat[i][j] = 0;
            if (i > 0) {
                walkMore(mat, i-1, j);
            }
            if (j > 0) {
                walkMore(mat, i, j-1);
            }
            if (i < mat.length - 1) {
                walkMore(mat, i+1, j);
            }
            if (j < mat[0].length - 1) {
                walkMore(mat, i, j+1);
            }
        }
        return 1;
    }

    private static void printMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }
}
