////class Men {
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


import java.util.ArrayList;
import java.util.List;

public class TesTClass {
    public static void main(String args[]) {

        int[] C = {2,2,1,1};
        System.out.println(reconstructMatrix(2, 3, C));
    }

    public static String reconstructMatrix(int U, int L, int[] C) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> row1 = new ArrayList<>();
//        List<Integer> row2 = new ArrayList<>();
        StringBuilder firstRow = new StringBuilder();
        StringBuilder secondRow = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0) {
                firstRow.append(0);
                secondRow.append(0);
            } else if (C[i] == 2) {
                if (U > 0 && L > 0) {
                    U--;
                    L--;
                } else {
                    if(result.length() == 0) {
                        result.append("IMPOSSIBLE");
                    }
                    return result.toString();
                }
                firstRow.append(1);
                secondRow.append(1);
            } else { if (U > 0 && U >= L) {
                    firstRow.append(1);
                    secondRow.append(0);
                    U--;
                } else if (L > 0 && U < L) {
                    firstRow.append(0);
                    secondRow.append(1);
                    L--;
                } else {
                    if(result.length() == 0) {
                        result.append("IMPOSSIBLE");
                    }
                    return result.toString();
                }
            }
        }
        if (U != 0 || L != 0) {
            if(result.length() == 0) {
                result.append("IMPOSSIBLE");
            }
            return result.toString();
        }
        result.append(firstRow);
        result.append(",");
        result.append(secondRow);
        return result.toString();
    }
}