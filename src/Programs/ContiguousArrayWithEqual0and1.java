package Programs;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
public class ContiguousArrayWithEqual0and1 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 0, 1};

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                count++;
            }else {
                count--;
            }
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        System.out.println(maxlen);
    }
}
