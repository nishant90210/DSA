package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/* http://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes */

public class RemoveDuplicates {

	public static void main(String[] args) {

		int arr[] = {3, 5, 7, 2, 2, 5, 7, 7};
//		int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		int i = removeDuplicatesFromUnSortedArray(arr, arr.length);
		for (int j = 0; j <= i; j++) {
			System.out.print(arr[j] + " ");
		}
	}

	private static int removeDuplicatesFromUnSortedArray(int[] arr, int length) {

		Arrays.sort(arr);
		int j = 0;
		for (int i = 0; i < length-1; i++) {
			if (arr[i] != arr[i+1]){
				arr[j] = arr[i];
				j++;
			}
		}
		arr[j] = arr[length-1];
		return j;
	}
}
