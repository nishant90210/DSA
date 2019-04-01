package String;

import java.util.Scanner;

public class Synopsis {

	public static void main(String[] args) {
		
		System.out.println("Enter the number");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		for (int i = number; i > 0; i--) {
			for (int j = number; j > i-1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
