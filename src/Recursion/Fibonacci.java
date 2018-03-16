package Recursion;

public class Fibonacci {

	public static void main(String[] args) {

		int i = 10;
		for (int j = 0; j <= i; j++) {
			System.out.println(fibonacci(j));
		}
		
	}

	private static int fibonacci(int j) {
		
		if(j == 0 || j == 1){
			return j;
		}
		else{
			int result1 = fibonacci(j-1);
			int result2 = fibonacci(j-2);
			int result = result1 + result2;
			return result;
		}
		
	}
	
}
