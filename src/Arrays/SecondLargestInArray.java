package Arrays;

/**
 * Created by NISHANT on 4/9/18.
 */
public class SecondLargestInArray {

    public static void main(String[] args) {

        int[] array = {6, 12, 5, 26, 7, 10, 3, 9, 2};
        int length = array.length;
        find2largest(array, length);
    }

    private static void find2largest(int[] array, int length) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {

            if (array[i] > firstMax) {
                firstMax = array[i];
            }
            if (array[i] > secondMax && firstMax != array[i]) {
                secondMax = array[i];
            }
        }
        System.out.println("First max : " + firstMax + " Second max " + secondMax);
    }
}