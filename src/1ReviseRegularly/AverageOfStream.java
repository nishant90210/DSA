package TopInterviewQuestions;

public class AverageOfStream {

    public static void main(String[] args)
    {
        float arr[] = { 10, 20, 30, 40, 50, 60 };
        int n = arr.length;
        streamAvg(arr, n);
    }

    private static void streamAvg(float[] arr, int n) {

        float prev_avg = arr[0];
        System.out.println(prev_avg);
        for (int i = 1; i < arr.length; i++) {
            prev_avg = getAvg(prev_avg, arr[i], i);
            System.out.println(prev_avg);
        }
    }

    private static float getAvg(float prev_avg, float arrayVal, int n) {

        float avg = (prev_avg * n + arrayVal) / (n + 1);
        return avg;
    }
}
