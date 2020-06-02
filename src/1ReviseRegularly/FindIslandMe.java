package TopInterviewQuestions;

public class FindIslandMe {

    public static void main(String[] args) {

        int count = 0;
        int mat[][] = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };

        if (mat.length == 0){
            return;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 1){
                    count += walkMore(mat, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static int walkMore(int[][] mat, int i, int j) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0){
            return 0;
        }
        mat[i][j] = 0;
        walkMore(mat, i+1, j);
        walkMore(mat, i, j+1);
        walkMore(mat, i-1, j);
        walkMore(mat, i, j-1);
        return 1;
    }

}
