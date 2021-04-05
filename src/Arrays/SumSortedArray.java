package Arrays;

// Given the sum, find the element from the two sorted array that equal the SUM given

public class SumSortedArray {

	public static void main(String[] args) {

		int sum = 11;
		int[] firstSortedArray = {2,5,8,9};
		int[] secondSortedArray = {3,4,7,10};

		int i = 0;
		int start = 0;
		int end = secondSortedArray.length - 1;

		while (i < firstSortedArray.length & i < secondSortedArray.length) {
			int totalSum = firstSortedArray[start] + secondSortedArray[end];
			if (totalSum == sum) {
				System.out.println("The two element whose sum equals the given SUM are " + firstSortedArray[start] + " and " + secondSortedArray[end]);
				break;
			} else if (totalSum > sum) {
				end--;
			} else {
				start++;
			}
		}
	}
}
