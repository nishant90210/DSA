package Matrix;

/**
 * Created by NISHANT on 1/23/18.
 */
public class MatrixRotationNxM {

    public static void main(String[] args) {

        int n = 5;
        int mat[][] = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},

        };

        transposeOnly(mat);
        int[][] rotate = rotate(mat);
        displayMatrix(rotate);
    }

    public static int [][] rotate(int[][] mat){

        int n = mat.length;
        int m = mat[0].length;
        int[][] output = new int[m][n];

        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                output[j][n - 1 - i] = mat[i][j];
            }
        }
        return output;
    }

    public static void transposeOnly(int arr[][])
    {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void displayMatrix(int[][] mat) {
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
