package Programs;

import java.util.HashMap;
import java.util.Map;

public class ElectionWinner {

    public static void main(String[] args) {

        String[] votes = new String[10];
        votes[0] = "Alex";
        votes[1] = "Michael";
        votes[2] = "Harry";
        votes[3] = "Dave";
        votes[4] = "Michael";
        votes[5] = "Victor";
        votes[6] = "Harry";
        votes[7] = "Alex";
        votes[8] = "Mary";
        votes[9] = "Mary";

        HashMap<String, Integer> hashMap = new HashMap();
        int count = 1;
        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];
            if (!hashMap.containsKey(vote)){
                hashMap.put(vote, count);
            }else{
                count = hashMap.get(vote);
                hashMap.put(vote, count+1);
            }
        }
        int max = 0;
        String str = "";
        for (Map.Entry<String, Integer> map : hashMap.entrySet()){
            String key = map.getKey();
            Integer value = map.getValue();
            if (value > max)
            {
                max = value;
                str = key;
            }else if (value == max && str.compareTo(key) < 0){
                str = key;
            }
        }
        System.out.println(str);
    }
}
