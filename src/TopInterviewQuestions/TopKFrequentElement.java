package TopInterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElement {

    public static void main(String args[])
    {
        int k = 2;
        int[] arr = { 3, 1, 4, 4, 5, 2, 6, 1, 1, 5};
        int n = arr.length;
        System.out.println(n);
        List<Integer> integers = kTop(arr, n, k);
//        List<Integer> integers = topKFrequent1(arr, k);
        System.out.println(integers);
    }

    public static List<Integer> topKFrequent1(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public static List<Integer> kTop(int[] arr, int length, int k) {

        int maxFreq = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i],0) + 1);
            maxFreq = Math.max(frequencyMap.get(arr[i]), maxFreq);
        }

        List<Integer>[] bucketList = new LinkedList[maxFreq + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucketList[frequency] == null) {
                bucketList[frequency] = new LinkedList<>();
            }
            bucketList[frequency].add(key);
        }

        int count = 0;
        List<Integer> ans = new LinkedList<>();
        for(int i= maxFreq; i >= 0; i--) {
            for(Integer j: bucketList[i]) {
                if(count < k) {
                    ans.add(j);
                    count++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
