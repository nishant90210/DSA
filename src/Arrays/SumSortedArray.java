package Arrays;

// Given the sum, find the element from the two sorted array that equal the SUM given

public class SumSortedArray {

	public static void main(String[] args) {

		int sum = 11;
		int[] firstSortedArray = {2,5,8,9};
		int[] secondSortedArray = {3,4,7,10};
		int i = 0;

		int j = firstSortedArray.length-1;
		int x = firstSortedArray[i];
		int y = secondSortedArray[j-i];
		int result = x + y;

		while (result != sum) {
			if(result > sum){
				y = secondSortedArray[j--];
				result = x + y;
			}
			else if (result < sum) {
				x = firstSortedArray[x++];
				result = x + y;
			}
		}
		System.out.println("The two element whose sum equals the given SUM are " + x + " " + y);
	}
}
