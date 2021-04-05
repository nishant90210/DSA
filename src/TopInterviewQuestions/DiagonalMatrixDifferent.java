package TopInterviewQuestions;

public class DiagonalMatrixDifferent {

    public static void main(String[] args) {
        int[][] mat = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
//                        {17, 18, 19, 20},
        };

        diagonalOrder(mat);
    }

    private static void diagonalOrder(int[][] mat) {

        int i = 0, j = 0, kite = 0;
        int n = mat.length;

        // Direction is initially from down to up
        boolean isUp = false;
        // Traverse the matrix till all elements get traversed
            while (kite < n * n){
            // If isUp = true then traverse from downward
            // to upward
            if (isUp) {
                while (i >= 0 && j < n) {
                    System.out.print(mat[i][j] + " ");
                    i--;
                    j++;
                    kite++;
                }

                // Set i and j according to direction
                if (i < 0 && j <= n - 1)
                    i = 0;
                if (j == n) {
                    i = i + 2;
                    j--;
                }
                System.out.println(" ");
            }

            // If isUp = false then traverse up to down
            else {
                while (j >= 0 && i < n) {
                    System.out.print(mat[i][j] + " ");
                    i++;
                    j--;
                    kite++;
                }

                // Set i and j according to direction
                if (j < 0 && i <= n - 1)
                    j = 0;
                if (i == n) {
                    j = j + 2;
                    i--;
                }
                System.out.println(" ");
            }

            // Revert the isUp to change the direction
            isUp = !isUp;
        }
    }
}
