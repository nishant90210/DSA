package TopInterviewQuestions;

import java.util.Arrays;

/**
 * Created by NISHANT on 4/5/18.
 */
// https://www.geeksforgeeks.org/majority-element/
public class MajorityElement {

    public static void main(String[] args)
    {
        int a[] = new int[]{1,3,4,4,1,4,4};
        Arrays.sort(a);
//        int a[] = new int[]{1, 3, 3, 1, 2};
        int size = a.length;
        int candidate = printMajority(a, size);
        System.out.println(candidate);
//        System.out.println(candidate);
//        if (isMajority(a, candidate, size)){
//            System.out.println(" " + candidate + " ");
//        }else {
//            System.out.println("No Majority Element");
//        }
    }

    private static boolean isMajority(int[] a, int candidate, int size) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == candidate){
                count++;
            }
        }
        if (count > (size/2)){
            return true;
        }
        return false;
    }

    private static int printMajority(int[] a, int size) {

        int result = 0, count = 0;

        for(int i = 0; i<a.length; i++ ) {
            if(count == 0){
                result = a[i];
                count = 1;
            }else if(result == a[i]){
                count++;
            }else{
                count--;
            }
        }

        return result;
    }
}
