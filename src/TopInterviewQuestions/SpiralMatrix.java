package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int a[][] = { { 1,  2,  3,  4,  5,  6 },
                      { 7,  8,  9,  10, 11, 12 },
                      { 13, 14, 15, 16, 17, 18 } };
        spiralPrint(a);
    }

    private static void spiralPrint(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while (rowBegin <= rowEnd && colBegin <= colEnd){


            for(int i = colBegin; i <= colEnd; i++){
                System.out.print(matrix[rowBegin][i]);
                System.out.print(" ");
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++){
                System.out.print(matrix[i][colEnd]);
                System.out.print(" ");
            }
            colEnd--;

            if (rowBegin <= rowEnd){
                for (int i = colEnd; i >= colBegin; i--) {
                    System.out.print(matrix[rowEnd][i]);
                    System.out.print(" ");
                }
            }
            rowEnd--;

            if (colBegin <= colEnd){
                for (int i = rowEnd; i >= rowBegin; i--) {
                    System.out.print(matrix[i][colBegin]);
                    System.out.print(" ");
                }
            }
            colBegin++;
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }
}
