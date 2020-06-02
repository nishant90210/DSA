package TopInterviewQuestions;

/**
 * Created by NISHANT on 3/30/18.
 */
public class PrintNestedArray {

    public static void main(String[] args) {

        //[1, 5, 8, 9, 10, [24, 20, [39, 48], 89], 105, 99]

        Object[] arraN_1_1 = {39,48};
        Object[] arraN_1 = {24,20,arraN_1_1,89};
        Object[] arraN = {1,5,8,9,10,arraN_1,105,99};

        printNestedArray(arraN);

    }

    private static void printNestedArray(Object[] arraN) {

        for (int i = 0; i < arraN.length; i++) {
            if (arraN[i].getClass().isArray()){
                Object[] tempArray = (Object[]) arraN[i];
                printNestedArray(tempArray);
            }else {
                System.out.print(arraN[i] + " ");
            }
        }
    }
}
