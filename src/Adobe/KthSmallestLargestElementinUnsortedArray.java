package Adobe;

import java.util.PriorityQueue;

public class KthSmallestLargestElementinUnsortedArray {

    public static void main(String[] args) {

        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer integer : arr) {
            pq.offer(integer);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq.poll());
    }
}
