package Programs;

import java.util.HashSet;

public class MoveZeroes {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 2};
        move(arr);
    }

    private static void move(int[] nums) {

        int count = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count = count + 1;
            }
        }
    }
}
