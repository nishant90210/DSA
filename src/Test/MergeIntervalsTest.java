package Test;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervalsTest {

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

//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]

        int[][] A = {
                {1, 5},
                {2, 3},
                {4, 6},
                {7, 8},
                {8, 10},
                {12, 15}
        };

        Interval[] intervals = new Interval[A.length];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(A[i][0], A[i][1]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        mergeIntervals(intervals);
    }

    private static void mergeIntervals(Interval[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i].end > a[i+1].start){

            }
        }
    }
}
















