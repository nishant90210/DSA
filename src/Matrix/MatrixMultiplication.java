package Matrix;

import java.util.Scanner;

public class MatrixMultiplication {

	Scanner scan;
	int matrix1[][], matrix2[][], multi[][];
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
		multi = new int[row][column];

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
	
	public void multiply() {
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				for (int k = 0; k < column; k++) {
					multi[i][j] = multi[i][j] + (matrix1[i][k] * matrix2[k][j]); 
				}
			}
		}
		System.out.println("\nThe Matrix is :");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("\t" + multi[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		MatrixMultiplication mul = new MatrixMultiplication();
		mul.create();
		mul.multiply();
	}
}