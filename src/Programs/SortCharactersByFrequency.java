package Programs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static void main(String[] args) {

        String s = "Aabb";
        System.out.println(sortByFreq(s));
    }

    private static String sortByFreq(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Map.Entry m : map.entrySet()){
            Character key = (Character) m.getKey();
            priorityQueue.offer(key);
        }

        while (!priorityQueue.isEmpty()){
            Character poll = priorityQueue.poll();
            Integer charVal = map.get(poll);
            while (charVal > 0) {
                stringBuilder.append(poll);
                charVal--;
            }
        }
        return stringBuilder.toString();
    }
}
