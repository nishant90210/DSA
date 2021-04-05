package TopInterviewQuestions;

public class DiagonalMatrix {

    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                        {17, 18, 19, 20},
        };

        diagonalOrder(arr);
        diagonalOrderInSingleLine(arr);
    }

    private static void diagonalOrderInSingleLine(int[][] arr) {

        for(int i =0;i<arr.length;i++){
            print(arr,i,0);
        }
        for(int i =1;i<arr[0].length;i++){
            print(arr,arr.length-1,i);
        }
    }

    public static void print(int[][] arr,int i, int j){
        while(i >= 0 && j < arr[0].length){
            System.out.print(arr[i--][j++]);
        }
    }

    private static void diagonalOrder(int[][] arr) {

        for(int kite = 0; kite < arr.length; kite++){
            int i = kite ;
            int vero = 0;
            while (i >= 0 & vero < arr.length-1){
                System.out.print(arr[i][vero] + " ");
                i = i - 1;
                vero = vero + 1;
            }
            System.out.println();
        }

        for(int kite = 1; kite < arr[0].length; kite++){
            int i = arr[0].length - 1;
            int vero = kite;
            while (vero <= arr[0].length-1) {
                System.out.print(arr[i][vero] + " ");
                i = i - 1;
                vero = vero + 1;
            }
            System.out.println();
        }
    }
}
