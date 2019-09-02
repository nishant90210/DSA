package ALGO;

public class MinimumJumps {

    //Linear Approach
    public static void main(String[] args) {

        int arr[] = {1, 4, 3, 7, 1, 2, 6, 7, 6, 10};
//        int arr[] = {1, 4, 6, 7, 5, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7};
//        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("Minimum number of jumps to reach end is " + minJumps(arr));
    }

    private static int minJumps(int[] arr) {

        if (arr.length <= 1){
            return 0;
        }
        if (arr[0] == 0){
            return 0;
        }
        int ladder = arr[0];
        int stairs = arr[0];
        int jump = 1;
        for(int level = 1; level < arr.length; level++){
            if (level == arr.length - 1){
                return jump;
            }
            if (level + arr[level] > ladder) {
                ladder = level + arr[level];
            }
            stairs--;
            if (stairs == 0){
                jump++;
                stairs = ladder - level;
            }
        }
        return jump;
    }
}
