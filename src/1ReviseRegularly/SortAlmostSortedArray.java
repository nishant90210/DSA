package Programs;

public class SortAlmostSortedArray {

    public static void main(String[] args)
    {
        int arr[] = {3, 5, 8, 7, 10, 15, 20, 25};
        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        sortByOneSwap(arr, n);
        System.out.println();
        System.out.println("Sorted array is ");
        printArray(arr, n);
    }

    private static void sortByOneSwap(int[] arr, int n) {

        int startTemp = Integer.MIN_VALUE, endTemp = Integer.MAX_VALUE;
        int start = 0, end = n-1;
        while (start < end){
            if (arr[start] > arr[start+1]){
                startTemp = start;
            }else {
                start++;
            }
            if (arr[end] < arr[end-1]){
                endTemp = end;
                break;
            }else {
                end--;
            }
        }
        int temp = arr[startTemp];
        arr[startTemp] = arr[endTemp];
        arr[endTemp] = temp;
    }

    private static void printArray(int[] arr, int n) {
        for (int i : arr) {
            System.out.print(i + " , ");
        }
    }
}
