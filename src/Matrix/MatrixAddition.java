package Matrix;

import java.util.Scanner;

public class MatrixAddition {

	Scanner scan;
	int matrix1[][], matrix2[][], sum[][];
	int row, column;
	
	public void create() {

		scan = new Scanner(System.in);

		System.out.println("Matrix Addition");

		// First Matrix Creation..
		System.out.println("\nEnter number of rows & columns");
		row = scan.nextInt();
		column = scan.nextInt();

		matrix1 = new int[row][column];
		matrix2 = new int[row][column];
		sum = new int[row][column];

		System.out.println("Enter the data for first matrix :");

		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				matrix1[i][j] = scan.nextInt();
			}
		}

		// Second Matrix Creation..
		System.out.println("Enter the data for second matrix :");
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				matrix2[i][j] = scan.nextInt();
			}
		}
	}
	
	public void display() {

		System.out.println("\nThe First Matrix is :");
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				System.out.print("\t" + matrix1[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n\nThe Second Matrix is :");
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				System.out.print("\t" + matrix2[i][j]);
			}
			System.out.println();
		}
	}
	
	public void add() {
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				sum[i][j] = matrix1[i][j] + matrix2[i][j]; 
			}
		}
		
		System.out.println("\nThe Matrix is :");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("\t" + sum[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args ) {
		
		MatrixAddition addition = new MatrixAddition();
		addition.create();
		addition.display();
		addition.add();
		
	}
	
}
