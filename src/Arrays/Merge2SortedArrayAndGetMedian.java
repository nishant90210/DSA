package Arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by NISHANT on 3/30/18.
 */
public class Merge2SortedArrayAndGetMedian {

    public static void main(String[] args) {

        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        int n1 = ar1.length;
        int n2 = ar2.length;
        System.out.println("Median is " + getMedian(ar1, ar2));
    }

    private static int getMedian(int[] arr1, int[] arr2) {

        int median = 0;
        int count = 0;
        int[] temp = new int[arr1.length+arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i];
            count++;
        }
        for (int i = 0; i < arr2.length; i++) {
            temp[count++] = arr2[i];
        }
        Arrays.sort(temp);
        for (int i : temp) {
            System.out.print(i + ", ");
        }
        int tempLength = temp.length;
        if (tempLength%2 == 0){
            median = (temp[tempLength/2-1] + temp[tempLength/2])/2;
        }else {
            median = temp[tempLength/2];
        }
        return median;
    }
}
