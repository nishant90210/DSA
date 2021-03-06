package TopInterviewQuestions;

import java.util.Arrays;

public class Merge2SortedArray {

    public static void main(String[] args) {
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};
        merge(arr1, arr2);
        System.out.print("After Merging First Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }

    private static void merge(int[] arr1, int[] arr2) {
        int length1 = arr1.length - 1;
        int length2 = arr2.length - 1;

        while (length2 >= 0) {
            if (arr1[length1] > arr2[length2]) {
                int temp = arr2[length2];
                arr2[length2] = arr1[length1];
                sortFirstArrayAfterSwap(arr1, temp);
                length2--;
            }
        }
    }

    private static void sortFirstArrayAfterSwap(int[] arr1, int temp) {

        int i = arr1.length - 1;
        while (i >= 0) {
            if (arr1[i] > temp) {
                arr1[i] = arr1[i - 1];
                i--;
            } else {
                arr1[i+1] = temp;
                break;
            }
        }
    }

//    static void merge(int arr1Length, int arr2Length, int[] arr1, int[] arr2)
//    {
//        // Iterate through all elements of ar2[] starting from
//        // the last element
//        for (int i = arr2Length-1; i >= 0; i--) {
//            /* Find the smallest element greater than ar2[i]. Move all
//               elements one position ahead till the smallest greater
//               element is not found */
//            int j, last = arr1[arr1Length-1];
//            for (j = arr1Length-2; j >= 0 && arr1[j] > arr2[i]; j--)
//                arr1[j+1] = arr1[j];
//
//            // If there was a greater element
//            if (j != arr1Length-2 || last > arr2[i])
//            {
//                arr1[j+1] = arr2[i];
//                arr2[i] = last;
//            }
//        }
//    }
}
