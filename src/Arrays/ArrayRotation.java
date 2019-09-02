package Arrays;

/**
 * Created by NISHANT on 4/5/18.
 */
public class ArrayRotation {

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        for (int i = 0; i < k; i++) {
            leftRotate(arr, k);
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void leftRotate(int[] arr, int k) {

            int j, temp;
            temp = arr[0];
            for (j = 0; j < arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
//        int gcd = gcd(2, 7);
//        System.out.println("adhj " + gcd);
    }

    private static void rightRotate(int[] arr, int k) {

        int temp, i;
        int length = arr.length;
        temp = arr[length - 1];
        for(i = length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }


    public static int gcd(int a, int b){
        {
            if (b == 0)
                return a;
            else
                return gcd(b, a % b);
        }
    }

}
