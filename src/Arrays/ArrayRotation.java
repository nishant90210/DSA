package Arrays;

/**
 * Created by NISHANT on 4/5/18.
 */
public class ArrayRotation {

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        for (int i = 0; i < k; i++) {
            leftRotate(arr, 2);
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void leftRotate(int[] arr, int k) {

        int temp = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
    }

}
