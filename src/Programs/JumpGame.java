package Programs;

public class JumpGame {

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        int lastIndex = nums.length-1;
        for(int i = lastIndex; i >=0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
    }
}
