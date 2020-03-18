package TopInterviewQuestions;

import java.util.ArrayList;

public class InsertInterval {

    static class Interval
    {
        int start,end;

        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public Interval() {
        }
    }

    public static void main(String[] args) {

        Interval intervals[]=new Interval[4];
        intervals[0]=new Interval(1,3);
        intervals[1]=new Interval(6,9);
//        intervals[2]=new Interval(8,10);
//        intervals[3]=new Interval(15,18);

        Interval newInterval = new Interval();
        newInterval = new Interval(2, 5);
        ArrayList<Interval> insert = insert(intervals, newInterval);
        for (Interval interval : insert) {
            System.out.println(interval);
        }
    }

    private static ArrayList<Interval> insert(Interval[] intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();
        for (Interval interval : intervals) {
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}
