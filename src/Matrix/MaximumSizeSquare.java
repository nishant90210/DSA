package Matrix;

public class MaximumSizeSquare {

    public static void main(String[] args) {

        int[][] mat = { {0, 1, 1, 0, 1},
                        {1, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0},
                        {1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0} };

        int[][] resultMat = new int[mat.length][mat[0].length];
        int maxSquare = calculateMaxSquare(mat, resultMat);
        System.out.println("Maximum Square :- " + maxSquare);
    }

    private static int calculateMaxSquare(int[][] mat, int[][] resultMat) {

        int max = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if (i == 0 || j == 0 || mat[i][j] == 0){
                    resultMat[i][j] = mat[i][j];
                }else {
                    resultMat[i][j] = Math.min(Math.min(resultMat[i-1][j-1], resultMat[i][j-1]), resultMat[i-1][j]) + 1;
                }
                if (resultMat[i][j] > max) {
                    max = resultMat[i][j];
                }
            }
        }
        return max;
    }
}
