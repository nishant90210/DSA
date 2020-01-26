package TopInterviewQuestions;

public class WaterTrap {

    static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    public static void main(String[] args) {

        System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
    }

    private static int findWater(int length) {

        int[] left = new int[length+1];
        int max = 0;
        int sum = 0;
        left[0] = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] >= max){
                left[i+1] = arr[i];
                max = arr[i];
            }else {
                left[i+1] = max;
            }
        }
        max = 0;
        for (int i = length; i > 0; i--) {
            if (arr[i-1] > max){
                max = arr[i-1];
            }
            sum = sum + (Math.min(max, left[i]) - arr[i-1]);
        }
        return sum;
    }
}
