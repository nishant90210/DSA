package CTCI.ArraysAndString;
//URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
//has sufficient space at the end to hold the additional characters, and that you are given the "true"
//length of the string. (Note: If implementing in Java, please use a character array so that you can
//perform this operation in place.)


//A common approach in string manipulation problems is to edit the string starting from the end and working
//backwards. This is useful because we have an extra buffer at the end, which allows us to change characters
//without worrying about what we're overwriting
public class QuestionURLify3 {

    //We will use this approach in this problem. The algorithm employs a two-scan approach. In the first scan, we
    //count the number of spaces. By tripling this number, we can compute how many extra characters we will
    //have in the final string. In the second pass, which is done in reverse order, we actually edit the string. When
    //we see a space, we replace it with %20. If there is no space, then we copy the original character


    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        System.out.println(str.length());
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) ;
        System.out.println(trueLength);
        replaceSpaces(arr, trueLength+1);
        System.out.println("\"" + QuestionURLify3.charArrayToString(arr) + "\"");
    }

    private static String charArrayToString(char[] arr) {

        String str = "";
        for (char c : arr) {
            str += c;
        }
        return str;
    }

    private static void replaceSpaces(char[] arr, int trueLength) {

        int count = 0;
        for (int c = 0; c < trueLength; c++){
            if (arr[c] == ' '){
                count++;
            }
        }
        int size = trueLength + count * 2;
        System.out.println(size);
        if (trueLength < arr.length){
            arr[trueLength] = '\0';
        }
        for (int j = trueLength-1; j >= 0; j--){
            if (arr[j] == ' '){
                arr[size - 1] = '0';
                arr[size - 2] = '2';
                arr[size - 3] = '%';
                size = size - 3;
            }else {
                arr[size-1] = arr[j];
                size--;
            }
        }
    }

    private static int findLastCharacter(char[] arr) {

        for (int i = arr.length-1; i >= 0; i--){
            if (arr[i] != ' '){
                return i;
            }
        }
        return -1;
    }
}
