package TopInterviewQuestions;

public class LongestIncreasingPathMatrix {

    public static void main(String[] args) {

        int[] max = new int[1];
        int maxV = 0;
        int count = 1;
        int mat[][] = {
                        {9,9,4},
                        {6,6,8},
                        {2,1,1}
                      };

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                LIPath(mat, i, j, max, count);
            }
        }
        System.out.println("max Path is : " + max[0]);
    }

    private static void LIPath(int[][] mat, int i, int j, int[] max, int count) {

        max[0] = Math.max(max[0], count);

        if (i < mat.length-1 && mat[i][j] < mat[i+1][j]){
            LIPath(mat, i+1, j, max, count+1);
        }
        if (j < mat[0].length-1 && mat[i][j] < mat[i][j+1]){
            LIPath(mat, i, j+1, max, count+1);
        }
        if (i > 0 && mat[i][j] < mat[i-1][j]){
            LIPath(mat, i-1, j, max, count+1);
        }
        if (j > 0 && mat[i][j] < mat[i][j-1]){
            LIPath(mat, i, j-1, max, count+1);
        }
    }
}
