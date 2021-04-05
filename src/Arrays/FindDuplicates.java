package Arrays;

/**
 * Created by NISHANT on 4/27/18.
 */
public class FindDuplicates {

    /*
    traverse the list for i= 0 to n-1 elements
    {
      check for sign of A[abs(A[i])] ;
      if positive then
         make it negative by   A[abs(A[i])]=-A[abs(A[i])];
      else  // i.e., A[abs(A[i])] is negative
         this   element (ith element of list) is a repetition
    }
     */
    public static void main(String[] args) {

        int arr[] = {2, 2, 1, 3, 3};
        int arr_size = arr.length;
        printRepeating(arr, arr_size);
    }

    public static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            int absOfIthElement = Math.abs(arr[i]);
            if (arr[Math.abs(absOfIthElement)] >= 0) {
                arr[absOfIthElement] = -arr[absOfIthElement];
            }
            else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }
}