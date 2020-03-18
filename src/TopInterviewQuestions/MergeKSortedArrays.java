package TopInterviewQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeKSortedArray(int[][] arr) {

        int total = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] integer : arr) {
            for (Integer intVal : integer){
                queue.offer(intVal);
                total++;
            }
        }

        int[] result = new int[total];
        int index = 0;
        while (!queue.isEmpty()){
            result[index] = queue.poll();
            index++;
        }
        return result;
    }


}
