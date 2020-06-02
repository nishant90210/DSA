package Arrays;

import java.util.ArrayList;

/**
 * Created by NISHANT on 3/27/18.
 */
// https://www.geeksforgeeks.org/generate-original-array-array-store-counts-greater-elements-right/
public class GenerateOriginalArray {

    public static void main(String[] args) {

        int arr[] = { 6, 3, 2, 1, 0, 0, 0 };
        int[] generate = generate(arr);
        for (int i : generate) {
            System.out.print(i + " ");
        }
    }

    public static int[] generate(int[] input) {
        int[] result = new int[input.length];
        ArrayList<Integer> remain = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            remain.add(input.length - i);
        }
        for(int i = 0; i < input.length; i++) {
            result[i] = remain.get(input[i]);
//            remain.remove(input[i]);
        }
        return result;
    }
}
