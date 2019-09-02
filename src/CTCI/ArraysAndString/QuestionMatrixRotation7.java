package CTCI.ArraysAndString;
//Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class QuestionMatrixRotation7 {

    public static void main(String[] args) {

        int mat[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
//                ,{19, 34, 14}
        };

        transpose(mat);
        Matrix.MatrixRotation.displayMatrix(3, mat);
        reverse(mat);
        System.out.println();
        Matrix.MatrixRotation.displayMatrix(3, mat);

    }

    //Right Rotation
    private static void reverse(int[][] mat) {
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j <= mat.length/2-1; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[0].length - 1 - j];
                mat[i][mat[0].length - 1 - j] = temp;
            }
        }

    }

    private static void transpose(int[][] mat) {

        for (int i = 0; i < mat.length; i++){
            for (int j = i; j < mat[0].length; j++){
                int temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
        }
    }
}
