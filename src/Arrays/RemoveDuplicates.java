package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/* http://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes */

public class RemoveDuplicates {

	public static void main(String[] args) {

//		int arr[] = {3, 5, 7, 2, 2, 5, 7, 7};
		int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
//		removeDup(arr);
//		removeDuplicates(arr);

	}

	static int removeDuplicatesForSortedArray(int arr[], int n)
	{
		int j = 0;
		if (n == 0 || n == 1)
			return n;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[i+1]){

			}
		}

		return j;
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

	private static void removeDup(Integer[] arr){

		ArrayList<Integer> primes = new ArrayList<Integer>(Arrays.asList(arr));
		int len = primes.size();
		for (int i = 0; i < len; i++) {
			Integer x = primes.get(i);
			for(int j=i+1;j<len;j++){
				if(x.equals(primes.get(j))){
					System.out.println(x + "removed");
					primes.remove(j);
					i--;
					len--;
				}
			}

		}

		System.out.println("new array list "+ primes);
	}

}
