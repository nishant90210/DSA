package Programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by NISHANT on 3/17/18.
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        String s = "wwwwaaadexxxxxx";
        runLength(s);
    }

    private static void runLength(String s) {

        LinkedHashMap<Character, Object> hashMap = new LinkedHashMap<>();
        int count = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (hashMap.get(c) == null){
                count = 1;
                hashMap.put(c, count);
            }else {
                hashMap.put(c, ++count);
            }
        }
        for (Map.Entry<Character, Object> entry : hashMap.entrySet()){
            String str = entry.getValue()+ "" + entry.getKey();
            System.out.print(str);
        }
    }
}
