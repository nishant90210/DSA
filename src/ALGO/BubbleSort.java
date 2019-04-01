package ALGO;

//Bubble sort,also referred to as sinking sort,
//is a simple sorting algorithm that works by repeatedly stepping through the list to be sorted,
//comparing each pair of adjacent items and swapping them if they are in the wrong order.
//worst case = O(n * n)

public class BubbleSort {

	public static void main(String[] args) {
		
		int temp;
		int[] array = {5, 1, 6, 2, 4, 3};
		for (int i = 0; i < array.length-1; i++) {
			while (i >= 0 && array[i] > array[i+1]) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				i--;
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}
	}
}
