package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by NISHANT on 3/31/18.
 */
//  https://www.geeksforgeeks.org/merging-intervals/
public class MergeOverlappingArrays {

    static class Interval {

        int begin;
        int end;

        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args)
    {
        List<Interval> intervals = Arrays.asList(new Interval(4, 6),
                                                    new Interval(2, 3),
                                                    new Interval(1, 5),
                                                    new Interval(7, 8),
                                                    new Interval(8, 10),
                                                    new Interval(12, 15));
        Collections.sort(intervals, (a, b) -> a.begin-b.begin);
        List<Interval> interval = mergeIntervals(intervals);
        for (Interval interval1 : interval) {
            System.out.println(interval1.begin+ "  " + interval1.end);
        }
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.begin > pre.end){
                result.add(pre);
                pre = curr;
            }else {
                Interval merged = new Interval(pre.begin, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);
        return result;
    }
}
