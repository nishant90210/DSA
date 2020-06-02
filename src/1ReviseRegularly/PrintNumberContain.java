package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by NISHANT on 3/16/18.
 */
//      https://www.cdn.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/

public class PrintNumberContain {

    public static void main(String[] args)
    {
        int[] numbers = { 123, 1232, 456, 234, 32145 };
        System.out.println(printNumbers(numbers));
    }

    private static String printNumbers(int[] numbers) {

        ArrayList<Integer> array = new ArrayList<>();
        for (int number : numbers) {
            if (findContainsOneTwoThree(number))
                array.add(number);
        }
        Collections.sort(array);
        boolean isFirst=true;
        String s="";
        for (Integer integer : array) {
            if (isFirst){
                s = s + integer;
                isFirst = false;
                continue;
            }
            s = s + "," + integer;

        }

        return s;
    }

    private static boolean findContainsOneTwoThree(int number) {

        String str = Integer.toString(number);
        if (str.contains("1") && str.contains("2") & str.contains("3")){
            return true;
        }
        return false;
    }
}
