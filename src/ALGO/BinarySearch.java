package ALGO;

public class BinarySearch {

//	public static void main(String[] args) {
//		
//		int[] array = {2, 3, 4, 7, 10, 14, 40, 67, 92};
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter number to searched");
//		int searchedInt = scanner.nextInt();
////		int mid = array.length/2;
//		int result = binarySearch(array, 0, array.length-1, searchedInt);
//		if(result == -1){
//			System.out.println("Element is not present in array"); 
//		}else{
//			System.out.println("Element is present at index "+ result);
//		}
//		
//	}
//
//	private static int binarySearch(int[] array, int low, int high, int searchedInt) {
//		
//		int mid = (low+high)/2;
//		
//		if (array[mid] == searchedInt){
//			return mid;
//		}
//		if(array[mid] > searchedInt){
//			return binarySearch(array, low, mid-1, searchedInt);
//		}
//		if(array[mid] < searchedInt){
//			return binarySearch(array, low, mid+1, searchedInt);
//		}
//		return -1;
//	}

	public int binarySearch(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if(key == inputArr[mid]){
				return mid;
			}else if (key > inputArr[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BinarySearch mbs = new BinarySearch();
		int[] arr = {2, 6, 13, 21, 36, 47, 63, 81, 97};
//		System.out.println("Key 14's position: "+mbs.binarySearch(arr, 13));
	}

}