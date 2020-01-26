package CTCI.ArraysAndString;
//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to 0.

import TopInterviewQuestions.FindIsland;

public class QuestionZeroMatrix8 {

    public static void main(String[] args) {

        int mat[][] = {
//                {1, 1, 1, 0},
//                {1, 1, 1, 0},
//                {1, 1, 0, 0},
//                {1, 0, 0, 0}

//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}

                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}

//                {1, 0}

        };
        boolean[] row = new boolean[mat.length];
        System.out.println("Printing row " + row.length);
        boolean[] column = new boolean[mat[0].length];
        System.out.println("Printing column " + column.length);

        //Mark row/col with 0
        markRowCol(mat, row, column);

        //NULLIFY ROW/COL
        nullifyRows(mat, row);
        nullifyColumn(mat, column);
        FindIsland.printMatrix(mat);
    }

    private static void markRowCol(int[][] mat, boolean[] row, boolean[] column) {
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j< mat[0].length; j++){
                if (mat[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    private static void nullifyRows(int[][] mat, boolean[] row) {

        for(int i = 0; i < mat.length; i++){
            if (row[i]){
                for(int j = 0; j < mat[0].length; j++){
                    mat[i][j] = 0;
                }
            }
        }
    }

    private static void nullifyColumn(int[][] mat, boolean[] column) {

        for(int i = 0; i < mat.length; i++){
            if (column[i]){
                for(int j = 0; j < mat.length; j++){
                    mat[j][i] = 0;
                }
            }
        }
    }
}
