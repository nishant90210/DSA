package TopInterviewQuestions;

public class Segregate0and1 {

    public static void main(String[] args)
    {
        int arr[] = new int[]{ 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        int n = arr.length;

        segregate0and1(arr, n);
        print(arr, n);

    }

    private static void segregate0and1(int[] arr, int n) {

        int i = 0, j = n-1, temp;
        while (i < j){
            if (arr[i] > arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (arr[i] < arr[j]){
                i++;
            } else if (arr[j] == 0){
                i++;
            } else {
                j--;
            }
        }
    }

    private static void print(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
