package Programs;

public class RangeSumQuery {

    public static void main(String[] args) {

        int[] arr = {-2, 0, 3, -5, 2, -1};
        int[] runningSumCache = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++){
            runningSumCache[i+1] += arr[i] + runningSumCache[i];
        }
        findSumRange(runningSumCache, 2, 5);
    }

    private static void findSumRange(int[] runningSumCache, int i, int j) {

        int sum = runningSumCache[j + 1] - runningSumCache[i];
        System.out.println("sum " + sum);
    }
}
