package TopInterviewQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {

    public static void main(String args[])
    {
        int k = 2;
        int[] arr = { 3, 1, 4, 4, 5, 2, 6, 1, 1, 5};
        int n = arr.length;
        System.out.println(n);
        List<Integer> integers = kTop(arr, n, k);
        System.out.println(integers);
    }

    private static List<Integer> kTop(int[] arr, int length, int k) {

        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            maxFreq = Math.max(map.get(arr[i]), maxFreq);
        }

        List<Integer>[] bucketList = new LinkedList[maxFreq+1];
        for(int i = 0; i <= maxFreq; i++){
            bucketList[i] = new LinkedList<>();
        }

        for (Integer key : map.keySet()){
            int freq = map.get(key);
            bucketList[freq].add(key);
        }

        int ct = 0;
        List<Integer> ans = new LinkedList<>();

        for(int i=maxFreq; i>=0; i--) {

            List<Integer> currentList = bucketList[i];

            for(Integer j: currentList) {
                if(ct < k) {
                    ans.add(j);
                    ct++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
