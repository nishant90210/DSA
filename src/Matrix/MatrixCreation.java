package Matrix;

import java.util.Scanner;

public class MatrixCreation {
	
	int rows, columns;
	int matrix[][];
	
	public void create() {
		
		System.out.println("Matrix Creation");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of rows :");
		rows = scanner.nextInt();
		
		System.out.println("Enter number of columns :");
		columns = scanner.nextInt();
		
		System.out.println("Enter the data :");
		matrix = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
	}
	
	public void display(){
		
		System.out.println("\nThe Matrix is :");
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		MatrixCreation creation = new MatrixCreation();
		creation.create();
		creation.display();
		
	}
	
}
