package Programs;

import java.util.HashMap;

public class ContiguousSubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,1};
        int n = nums.length;
        int target = 3;

        int count = 0;

        getSubArrayCountInOn2(nums, n, target, count);
        getSubArrayCountInOn(nums, n, target, count);
    }

    private static void getSubArrayCountInOn(int[] nums, int n, int k, int count) {

        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(count);
    }

    private static void getSubArrayCountInOn2(int[] nums, int n, int target, int count) {
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == target){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
