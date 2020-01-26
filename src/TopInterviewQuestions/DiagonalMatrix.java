package TopInterviewQuestions;

public class DiagonalMatrix {

    public static void main(String[] args) {
        int arr[][] = { {1,  2,  3,  4},
                        {5,  6,  7,  8},
                        {9,  10, 11, 12},
                        {13, 14, 15, 16},
                        {17, 18, 19, 20},
                      };

        diagonalOrder(arr);
    }

    private static void diagonalOrder(int[][] arr) {

        for(int k = 0; k < arr.length; k++){
            int i = k ;
            int j = 0;
            while (i >= 0 & j < arr.length-1){
                System.out.print(arr[i][j] + " ");
                i = i - 1;
                j = j + 1;
            }
            System.out.println();
        }

        for(int k = 1; k < arr[0].length; k++){
            int i = arr[0].length - 1;
            int j = k;
            while (j <= arr[0].length-1) {
                System.out.print(arr[i][j] + " ");
                i = i - 1;
                j = j + 1;
            }
            System.out.println();
        }
    }
}
