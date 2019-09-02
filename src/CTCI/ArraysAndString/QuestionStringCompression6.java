package CTCI.ArraysAndString;
//String Compression: Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
//"compressed" string would not become smaller than the original string, your method should return
//the original string. You can assume the string has only uppercase and lowercase letters (a - z).

public class QuestionStringCompression6 {

    public static void main(String[] args) {

        String input = "aabcccccaaa";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < input.length(); i++){
            if (i+1 < input.length() && input.charAt(i) == input.charAt(i+1)){
                count++;
            }else {
                sb.append(input.charAt(i) + "" +count);
                count = 1;
            }
        }
        System.out.println(sb);
    }
}
