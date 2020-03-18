package TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShortenUrl {

    Map<String, String> longToShort = new HashMap<>();
    Map<String, String> shortToLong = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        while(true) {
            String shortUrl = "http://tinyurl.com/" + generateShortUrl();
            if(!shortToLong.containsKey(shortUrl)) {
                shortToLong.put(shortUrl, longUrl);
                longToShort.put(longUrl, shortUrl);
                return shortUrl;
            }
        }
    }

    private String generateShortUrl() {
        String charArr = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        for(int i = 0; i < 6; i++) {
            Random rand = new Random();
            int index = rand.nextInt(62);
            res += charArr.charAt(index);
        }
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!shortToLong.containsKey(shortUrl)) {
            return null;
        }
        return shortToLong.get(shortUrl);
    }

    public static void main(String[] args) {

        ShortenUrl sort  = new ShortenUrl();
        String s = sort.generateShortUrl();
        System.out.println(s);
        String encode = sort.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/346421/two-solutions-in-java-base-62-random-generation");
        System.out.println(encode);
        String decode = sort.decode(encode);
        System.out.println(decode);
    }
}
