package Arrays;

import java.util.ArrayList;

/* http://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes */

public class RemoveDuplicates {

	public static void main(String[] args) {
	
		int arr[] = {3, 5, 7, 2, 2, 5, 7, 7};
		removeDuplicates(arr);

	}

	private static void removeDuplicates(int[] arr) {
		// Time Complexity = O(n^2)		
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				int x = arr[i];
				int y = arr[j];
				if(x == y){
					continue;
				}else{
					if (newArray.contains(arr[i])) {
						break;
					}
					newArray.add(arr[i]);
				}
			}
		}
		System.out.println(newArray);
	}
}
