package Matrix;

/**
 * Created by NISHANT on 1/23/18.
 */
public class MatrixRotation {

    public static void main(String[] args) {

        int n = 5;
        int mat[][] = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println(" Before Transpose := ");
        displayMatrix(n, mat);
        transpose(mat, n);
        System.out.println(" After Transpose := ");
        displayMatrix(n, mat);
        System.out.println(" Before Reverse := ");
        displayMatrix(n, mat);
        reverseColumns(mat,n);
        System.out.println(" After Reverse := ");
        displayMatrix(n, mat);


//        System.out.println(" Before Rotation := ");
//        displayMatrix(n, mat);
//        rotate90(n, mat);
//        System.out.println(" After Rotation := ");
//        displayMatrix(n, mat);
    }

    static void transpose(int arr[][], int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
            {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
    }

    static void reverseColumns(int arr[][], int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = n-1,  x = 0; x < j; j--, x++)
            {
                int temp = arr[x][i];
                arr[x][i] = arr[j][i];
                arr[j][i] = temp;
            }
    }

    public static void displayMatrix(int n, int[][] mat) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }
}
