package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NISHANT on 4/25/18.
 */
public class Lilliput {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        String[][] booksRequests= new String[][]{
                {"Go, Dog. Go", "user1"},    //  the book "Go, Dog. Go" was requested by "user1"
                {"The Hobbit", "user2"},
                {"The Hobbit", "user2"},    // yes, we can have repetitions
                {"The Lion and the Mouse", "user3"},
                {"The Hobbit", "user3"},
                {"The Hobbit", "user1"},
                {"Go, Dog. Go", "user1"},
                {"Go, Dog. Go", "user2"},
        };
        findUser(map, booksRequests);
    }

    private static void findUser(HashMap<String, Integer> bookMap, String[][] booksRequests) {

        Integer count = 1;
        for(int i=0; i< booksRequests.length; i++){
            if (!bookMap.containsKey(booksRequests[i][0])){
                bookMap.put(booksRequests[i][0], count);
            }else{
                count = bookMap.get(booksRequests[i][0]);
                bookMap.put(booksRequests[i][0], count+1);
            }
        }
        for (Map.Entry map : bookMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
