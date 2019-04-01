package Queue;

/**
 * Created by NISHANT on 9/18/17.
 */
public class SlidingWindow {

    public static void main(String[] args)
    {
        int arr[]={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k=4;
        printMax(arr, arr.length,k);
    }

    private static void printMax(int[] arr, int length, int k) {

        for (int i = 0; i <= length-k ; i++) {
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                if (max < arr[i+j]){
                    max = arr[i+j];
                }
            }
            System.out.print(" " + max);
        }
    }
}
