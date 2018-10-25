package Arrays;

/**
 * Created by NISHANT on 4/9/18.
 */
public class SmallestAndLargest {

    public static void main(String[] args) {

        int[] array = {6, 12, 5, 26, 7, 10, 3, 9, 4};
        int length = array.length;
        smallestAndLargest(array, length);
    }

    private static void smallestAndLargest(int[] array, int length) {

        int smallest = 0, largest = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] > largest){
                largest = array[i];
            }
            if (array[i] < largest){
                smallest = array[i];
            }
        }
        System.out.println("Smallest " + smallest);
        System.out.println("Largest " + largest);
    }
}
