package Test;

public class FrontPalin {

    public static void main(String[] args) {

        String str = "BABABAA";
        String s = makePalin(str, str.length());
        System.out.println(s);
    }

    private static String makePalin(String word, int length) {

        StringBuilder res = new StringBuilder(word);
        int count = 0;
        int start = 0;
        int end = length-1;

        while (start < end) {

            if (word.charAt(start) == word.charAt(end)){
                start++;
                end--;
            } else {
                char c = word.charAt(end);
                res.insert(0, c);
                count++;
                end--;
            }
        }
        System.out.println(count);
        return res.toString();
    }
}
