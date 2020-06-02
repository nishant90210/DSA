package Programs;

public class FindTheCelebrity {

    public static void main(String[] args) {

        int n = 10;
        int left = 0, right = n-1;
        while (left < right) {
            if(knows(left, right)){
                left++;
            }else {
                right--;
            }
        }

        for (int i = 0; i < n; i++){
            if (i != left && !knows(left, i) || knows(i, left)){
                System.out.println("-1");
            }
        }
        System.out.println(left + " is a celebrity");
    }

    private static boolean knows(int left, int right) {

        return true;
    }
}
