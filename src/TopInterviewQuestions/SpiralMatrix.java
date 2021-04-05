package TopInterviewQuestions;

public class SpiralMatrix {

    public static void main(String[] args) {

        int a[][] = { { 1,  2,  3,  4,  5,  6 },
                      { 7,  8,  9,  10, 11, 12 },
                      { 13, 14, 15, 16, 17, 18 },
                      { 19, 20, 21, 22, 23, 24 }
        };
        spiralPrint(a);
    }

    private static void spiralPrint(int[][] a) {

        int rowBegin = 0;
        int rowEnd = a.length - 1;
        int colBegin = 0;
        int colEnd = a[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = rowBegin; i <= colEnd; i++) {
                System.out.print(a[rowBegin][i]);
                System.out.print(" ");
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                System.out.print(a[i][colEnd]);
                System.out.print(" ");
            }
            colEnd--;
            for (int i = colEnd; i >= colBegin; i--) {
                System.out.print(a[rowEnd][i]);
                System.out.print(" ");
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                System.out.print(a[i][colBegin]);
                System.out.print(" ");
            }
            colBegin++;
        }

    }
}
