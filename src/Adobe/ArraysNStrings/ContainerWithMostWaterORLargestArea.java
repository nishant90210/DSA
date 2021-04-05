package Adobe.ArraysNStrings;

public class ContainerWithMostWaterORLargestArea {

    public static void main(String[] args) {

//        int[] arr = {1, 4, 6, 5, 3, 7, 6, 2};
//        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] arr = {4,3,2,1,4};
        int[] arr = {2, 1};
//        System.out.println(calculateLargestAreaBF(arr));
        System.out.println(calculateLargestArea2P(arr));
    }

    // Brute Force
    // Time = O(n^2)
    // Space = O(1)
    private static int calculateLargestAreaBF(int[] arr) {

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int area = calculateArea(arr, i, j);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private static int calculateArea(int[] arr, int i, int j) {

        int height = Math.min(arr[i], arr[j]);
        int area = height * (j-i);
        return area;
    }

    // Two Pointer Approach
    // Time = O(n)
    // Space = O(1)
    private static int calculateLargestArea2P(int[] arr) {

        int maxArea = 0;
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            maxArea = Math.max(maxArea, (Math.min(arr[start], arr[end]) * (end - start)));
            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }


}
