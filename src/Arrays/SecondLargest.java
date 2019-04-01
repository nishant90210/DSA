package Arrays;

/**
 * Created by Nishant on Nov, 2018
 */
public class SecondLargest {

    public static void main(String[] args)
    {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
        print2largest(arr, n);
    }

    private static void print2largest(int[] arr, int n) {

        int first, second;
        first = second = Integer.MIN_VALUE;
        if (n < 2){
            System.out.print(" Invalid Input ");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first){
                second = first;
                first = arr[i];
            }
            else if (arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE)
            System.out.print("There is no second largest element\n");
        else
            System.out.print("The second largest element is "+ second);
    }
}
