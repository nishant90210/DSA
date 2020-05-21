package Programs;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {

        int maxSum, reverseMaxSum;
        int total = 0;
        int A[] = {-2,-3,-1};
        maxSum = kadane(A);
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            A[i] = -A[i];
        }
        reverseMaxSum = kadane(A);
        int result = Math.max(maxSum, reverseMaxSum+total);
        if (result == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    public static int kadane(int[] A) {

        int maxSoFar = A[0], maxEndingHere = A[0];
        for(int i = 1; i < A.length; i++){
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
