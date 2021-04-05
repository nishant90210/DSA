package Programs;

import java.util.*;

public class IntervalListIntersections {

    static class Interval {

        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {

        List<Interval[]> list = new ArrayList();
        List<Interval> newList = new ArrayList();
        int[][] A = {
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        };

        int[][] B = {
                {1,5},
                {8,12},
                {15,24},
                {25,26}
        };

        int[][] ints = intervalIntersection(A, B);
        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            System.out.println(anInt[0] +  " " +anInt[1]);
        }
    }

    private static int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int r = Math.min(A[i][1], B[j][1]);
            if (l <= r) {
                ans.add(new int[]{l, r});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            }else {
                j++;
            }
        }
        return ans.toArray(new int[0][0]);
    }

}














