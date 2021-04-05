package TopInterviewQuestions;////class Men {
////    public int number;
////}
////
////public class TesTClass {
////
////    public void doIt(int i, Men p){
////        i = 5;
////        p.number = 8;
////    }
////
////    public static void main(String[] args) {
////
////        int x = 0;
////        Men p = new Men();
////        new TesTClass().doIt(x, p);
////        System.out.println(x +  " " + p.number);
////    }
////}
//
//class Aa{
//    final public int GetResult(int a, int b){
//        return 0;
//    }
//}
//
//class Bb extends Aa{
//    public int GetResult(int a, int b){
//        return 1;
//    }
//}
//
//public class TesTClass {
//
//    public static void main(String[] args) {
//
//        Bb bb = new Bb();
//        System.out.println("x = " + bb.GetResult(0, 1));
//    }
//}

//import java.util.LinkedList;
//import java.util.Queue;
//
//public class TesTClass {
//
//    public static void main(String[] args) {
//
////        long num = 3;
////        StringBuilder sb = new StringBuilder();
////        for (int i = 1; i <= num; i++) {
////             sb.append(Integer.toBinaryString(i));
////        }
////        String number = sb.toString();
////        int i = Integer.parseInt(number, 2);
////        Long l = new Long(i);
////        System.out.println(l);
////        long n = 3;
////        StringBuilder sb = new StringBuilder();
////        String generate = generate(n);
////        System.out.println(generate);
////        int i = Integer.parseInt(generate, 2);
//        String s = "11011";
//        int i1 = Integer.parseInt(s);
//        int i = i1 % 7;
//        System.out.println(i);
//    }
//
//    public static String generate(long n)
//    {
//        // create an empty Queue and push 1 to it
//        StringBuilder sb = new StringBuilder();
//        Queue<String> q = new LinkedList<>();
//        q.add("1");
//
//        // run n times
//        int i = 1;
//        while (i++ <= n) {
//            // append 0 and 1 to the front element of the queue and
//            // enqueue both Strings
//            q.add(q.peek() + '0');
//            q.add(q.peek() + '1');
//
//            // pop the front element and print it
////            System.out.print(q.poll() + ' ');
//            sb.append(q.poll());
//        }
//        return sb.toString();
//    }
//
//}


public class FindOriginalString {
    public static void main(String args[]) {
        String S = "cdeo";
        int[] A = {3, 2, 0, 1};
        System.out.println(solution(S, A));
    }

    public static String solution(String S, int[] A) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder(String.valueOf(S.charAt(0)));
        int index = 0;
        int i = S.length();
        while (i > 1) {
            sb.append(S.charAt(A[index]));
            index = A[index];
            if(A[index] == 0) {
                return sb.toString();
            }
            i--;
        }
        return sb.toString();
    }
}