package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
public class InsertInterval {

    static class Interval{
        int start;
        int end;

        Interval(int start, int end){
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

        Interval intervals[]=new Interval[4];
        intervals[0]=new Interval(1,3);
        intervals[1]=new Interval(6,9);
        intervals[2]=new Interval(8,10);
        intervals[3]=new Interval(15,18);

        Interval newInterval = new Interval(2, 5);

        List<Interval> intervals1 = insertInterval(intervals, newInterval);
        for (Interval interval : intervals1) {
            System.out.println(interval);
        }
    }

    private static List<Interval> insertInterval(Interval[] intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end < newInterval.start){
                result.add(intervals[i]);
            }else if (intervals[i].start > newInterval.end){
                result.add(newInterval);
                newInterval = intervals[i];
            }else {
                newInterval = new Interval((Math.min(intervals[i].start, newInterval.start)), Math.max(intervals[i].end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}


















