package Arrays;

import java.util.Scanner;

public class ArrayInputFromUser {

public static void main(String[] args) {
		
		arrayInputFromUser();
	}

	public static void arrayInputFromUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of element of an Array");
		int arrayElement = scan.nextInt();
		int[] elements = new int[arrayElement];
		for (int i = 0; i < elements.length; i++) {
			System.out.println("Enter the array element at index "+ i);
			elements[i] = scan.nextInt();
		}
		System.out.println("Elements of the array = ");
		System.out.print("[ ");
		for (int i = 0; i < elements.length; i++) {
			
			System.out.print(elements[i]+" ");
		}
		System.out.print("]");
	}
	
}
