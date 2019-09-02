package Matrix;

public class SubmatrixSum {

    static final int M = 4;
    static final int N = 5;

    public static void main(String[] args) {

        int mat[][] = { {1, 2, 3, 4, 6},
                        {5, 3, 8, 1, 2},
                        {4, 6, 7, 5, 5},
                        {2, 4, 8, 9, 4} };

        int aux[][] = new int[M][N];
        preprocessMatrix(mat, aux);

        int tli = 2, tlj = 2, rbi = 3, rbj = 4;
        System.out.print("\nQuery1: " + sumQuery(aux, tli, tlj, rbi, rbj));

        tli = 0; tlj = 0; rbi = 1; rbj = 1;
        System.out.print("\nQuery2: " + sumQuery(aux, tli, tlj, rbi, rbj));

        tli = 1; tlj = 2; rbi = 3; rbj = 3;
        System.out.print("\nQuery3: " + sumQuery(aux, tli, tlj, rbi, rbj));
    }

    // A O(1) time function to compute sum
    // of submatrix between (ti, tj) and
    // (ri, rj) using aux[][] which is
    // built by the preprocess function
    private static int sumQuery(int aux[][], int ti, int tj, int ri, int rj) {

        // result is now sum of elements between (0, 0) and (ri, rj)
        int res = aux[ri][rj];

        // Remove elements between (0, 0) and (ti-1, rj)
        if (ti > 0) {
            res = res - aux[ti - 1][rj];
        }
        // Remove elements between (0, 0)
        // and (ri, tj-1)
        if (tj > 0) {
            res = res - aux[ri][tj - 1];
        }

        // Add aux[ti-1][tj-1] as elements
        // between (0, 0) and (ti-1, tj-1)
        // are subtracted twice
        if (ti > 0 && tj > 0) {
            res = res + aux[ti - 1][tj - 1];
        }

        return res;
    }

    private static void preprocessMatrix(int[][] mat, int[][] aux) {

        // Copy first row of mat[][] to aux[][]
        for(int i = 0; i <= M ; i++){
            aux[0][i] = mat[0][i];
        }

        // Do column wise sum
        for (int i = 1 ; i < M ; i++){
            for (int j = 0 ; j < N ; j++){
                aux[i][j] = mat[i][j] + aux[i-1][j];
            }
        }

        // Do row wise sum
        for(int i = 0; i < M; i++){
            for (int j = 1; j < N; j++) {
                aux[i][j] = aux[i][j] + aux[i][j-1];
            }
        }

        printMatrix(aux);
    }

    private static void printMatrix(int[][] aux) {
        for (int x = 0; x < M ; x++){
            for (int y = 0; y < N; y++) {
                System.out.print(aux[x][y] + " ");
            }
            System.out.println();
        }
    }

}
