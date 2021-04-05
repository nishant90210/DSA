package String;

public class EqulibriumIndex {
	public static void main(String[] args) {
		int[] sequence = {-7, 1, 5, 2, -4, 3, 0};
		equlibrium_indices(sequence);
		equlibriumIndex(sequence);
	}

	private static void equlibriumIndex(int[] sequence) {

		int total = 0;
		int sum_till_i = 0;
		for (int i : sequence) {
			total += i;
		}

		for (int i = 0; i < sequence.length-1; i++) {
			sum_till_i += sequence[i];
			int sum_except_i_elemet = total - (sequence[i + 1] + sum_till_i);
			if (sum_except_i_elemet == sum_till_i) {
				System.out.println("index " + (i+1) + " and the number is " + sequence[i + 1]);
			}
		}
	}


	public static void equlibrium_indices(int[] sequence){
		//find total sum
		int totalSum = 0;
		for (int n : sequence) {
			totalSum += n;
		}
		//compare running sum to remaining sum to find equlibrium indices
		int runningSum = 0;
		for (int i = 0; i < sequence.length; i++) {
			int n = sequence[i];
			if (totalSum - runningSum - n == runningSum) {
				System.out.println("index " + i + " and the number is " + n);
			}
			runningSum += n;
		}
	}
}
