package TopInterviewQuestions;

public class SumWithNoAdjacentElement {

    public static void main(String[] args) {

        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }
}
