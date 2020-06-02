package TopInterviewQuestions;

import java.util.HashMap;

//Find pairs whose sum is equal to each other
public class FindPairs {

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        int n = arr.length;
        findPairs(arr, n);
    }

    static class Pair {

        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static void findPairs(int[] arr, int n) {

        boolean found = false;
        HashMap<Integer, Pair> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (!hashMap.containsKey(sum)){
                    hashMap.put(sum, new Pair(arr[i],arr[j]));
                }else {
                    found = true;
                    Pair pair = hashMap.get(sum);
                    System.out.println("(" + pair.first + "," + pair.second + ") and " + "(" + arr[i] + "," + arr[j] + ")");
                }
            }
        }
        if (!found){
            System.out.println("No pairs found");
        }
    }
}
