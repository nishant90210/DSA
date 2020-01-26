package TopInterviewQuestions;

public class FindIslandMe {

    public static void main(String[] args) {

        int count = 0;
        int mat[][] = {
                {1,1,1},
                {0,1,0},
                {0,0,1}
        };

        if (mat.length == 0){
            return;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 1){
                    count += walk(mat, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static int walk(int[][] mat, int i, int j) {

        if (mat[i][j] == 1){
            mat[i][j] = 0;
            if (j < mat[0].length - 1){
                walk(mat, i, j+1);
            }
            if (i < mat.length - 1){
                walk(mat, i+1, j);
            }
            if (i > 0){
                walk(mat, i-1, j);
            }
            if (j > 0){
                walk(mat, i, j-1);
            }
        }
        return 1;
    }
}
