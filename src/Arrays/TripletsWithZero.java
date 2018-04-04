package Arrays;

/**
 * Created by NISHANT on 3/19/18.
 */
public class TripletsWithZero {

    public static void main(String[] args)
    {
        int arr[] = {0, -1, 2, -3, 1};
        int n =arr.length;
        findTriplets(arr, n);

    }

    private static void findTriplets(int[] arr, int n) {

        boolean tripletsFound = false;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0){
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k] );
                        tripletsFound = true;
                    }
                }
            }
        }
        if (!tripletsFound){
            System.out.println("Not found");
        }
    }
}
