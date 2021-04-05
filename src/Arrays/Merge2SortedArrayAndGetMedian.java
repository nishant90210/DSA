package Arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by NISHANT on 3/30/18.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Merge2SortedArrayAndGetMedian {

    public static void main(String[] args) {

//        int ar1[] = {1, 12, 15, 26, 38};
//        int ar2[] = {2, 13, 17, 30, 45};
        int ar1[] = {-5, 5, 6, 12, 15};
        int ar2[] = {-12, -10, -6, -3, 4, 10};
        int n1 = ar1.length;
        int n2 = ar2.length;
        System.out.println("Median is " + getMedian(ar1, ar2));
        System.out.println("Median is " + findMedianSortedArrays(ar1, ar2));
    }

    private static double findMedianSortedArrays(int[] input1, int[] input2) {

        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int piyush = input1.length;
        int anand = input2.length;
        int vivek = 0;
        int ranjan = input1.length;
        while (vivek <= ranjan){
            int partitionVivekRanjan1Grp = (vivek + ranjan)/2;
            int partitionPiyushAnand2Grp = (piyush + anand + 1)/2 - partitionVivekRanjan1Grp;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int minLeftVivekRanjan = (partitionVivekRanjan1Grp == 0) ? Integer.MIN_VALUE : input1[partitionVivekRanjan1Grp - 1];
            int maxRightVivekRanjan = (partitionVivekRanjan1Grp == piyush) ? Integer.MAX_VALUE : input1[partitionVivekRanjan1Grp];

            int minLeftPiyushAnand = (partitionPiyushAnand2Grp == 0) ? Integer.MIN_VALUE : input2[partitionPiyushAnand2Grp - 1];
            int maxRightPiyushAnand = (partitionPiyushAnand2Grp == anand) ? Integer.MAX_VALUE : input2[partitionPiyushAnand2Grp];

            if (minLeftVivekRanjan <= maxRightPiyushAnand && minLeftPiyushAnand <= maxRightVivekRanjan) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((piyush + anand) % 2 == 0) {
                    return ((double)Math.max(minLeftVivekRanjan, minLeftPiyushAnand) + Math.min(maxRightVivekRanjan, maxRightPiyushAnand))/2;
                } else {
                    return (double)Math.max(minLeftVivekRanjan, minLeftPiyushAnand);
                }
            } else if (minLeftVivekRanjan > maxRightPiyushAnand) { //we are too far on right side for partitionX. Go on left side.
                ranjan = partitionVivekRanjan1Grp - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                vivek = partitionVivekRanjan1Grp + 1;
            }
        }
        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        return 0.0;
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
