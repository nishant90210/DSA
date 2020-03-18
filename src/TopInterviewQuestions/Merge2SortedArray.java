package TopInterviewQuestions;

import java.util.Arrays;

public class Merge2SortedArray {

    public static void main(String[] args)
    {
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};
        merge(arr1.length,arr2.length, arr1, arr2);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }

    static void merge(int arr1Length, int arr2Length, int[] arr1, int[] arr2)
    {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i = arr2Length-1; i >= 0; i--) {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[arr1Length-1];
            for (j = arr1Length-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];

            // If there was a greater element
            if (j != arr1Length-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
