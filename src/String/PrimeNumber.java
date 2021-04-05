package String;

import java.io.InputStreamReader;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		boolean flag = false;
		Integer res;
		System.out.println("Enter the Number");
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		Integer number = scanner.nextInt();
		for (int i = 2; i <= Math.sqrt(number); i++) {
			res = number % i;
			if(res == 0){
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Not Prime");
		}
		else{
			System.out.println("Prime");
		}
	}
}