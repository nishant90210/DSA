package TopInterviewQuestions;

public class GradualDec {

    public static void main(String[] args) {

        int n = 11;
        recurs(n);
    }

    private static void recurs(int n) {

        if (n <= 0){
            System.out.println(n);
            return;
        }else {
            System.out.println(n);
            recurs(n-5);
        }
        System.out.println(n);
    }
}
