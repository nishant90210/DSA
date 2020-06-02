package Programs;

import java.util.PriorityQueue;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
public class LastStoneWeight {

    public static void main(String[] args) {

        int[] input = {2,7,4,1,8,1};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i : input) {
            maxHeap.add(-i);
        }
        while (maxHeap.size() > 1){
            int stoneOne = maxHeap.poll();
            int stoneTwo = maxHeap.poll();
            int result = stoneOne - stoneTwo;
            maxHeap.add(result);
        }
        System.out.println(-maxHeap.poll());
    }
}
