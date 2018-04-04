package Arrays;

/**
 * Created by NISHANT on 3/27/18.
 */

//  https://www.geeksforgeeks.org/find-original-array-encrypted-array-array-sums-elements/
public class OriginalFromEncrypted {
    public static void findAndPrintOriginalArray(int arr[], int n)
    {
        int arr_sum = 0;
        for (int i = 0; i < n; i++)
            arr_sum += arr[i];

        arr_sum = arr_sum / (n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(arr_sum - arr[i] + " ");
    }

    public static void main (String[] args)
    {
        int arr[] = {10, 14, 12, 13, 11};
        int n =arr.length;
        findAndPrintOriginalArray(arr, n);
    }
}