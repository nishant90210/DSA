package TopInterviewQuestions;

public class WaterTrap {

    static int arr[] = new int[] {3, 0, 2, 0, 4};

    public static void main(String[] args) {

        System.out.println("Maximum water that can be accumulated is " + findWater(arr));
    }

    private static int findWater(int[] height) {

        int[] left = new int[height.length+1];
        int max = 0;
        int sum = 0;
        left[0] = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
            }
            left[i+1] = max;
        }
        max = 0;
        for (int i = height.length; i > 0; i--) {
            if(height[i-1] > max){
                max = height[i-1];
            }
            sum = sum + (Math.min(max, left[i]) - height[i-1]);
        }
        return sum;
    }
}
