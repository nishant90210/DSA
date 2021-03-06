package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

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
    }

    public static void main(String args[]) {
        Interval arr[]=new Interval[6];
        arr[0]=new Interval(1,5);
        arr[1]=new Interval(2,3);
        arr[2]=new Interval(4,6);
        arr[3]=new Interval(7,8);
        arr[4]=new Interval(8,10);
        arr[5]=new Interval(12,15);

//        Old Fashined Comparator
//        Arrays.sort(arr, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval i1, Interval i2) {
//                return i1.start - i2.start;
//            }
//        });

//      lambda expression Comparator
//      Arrays.sort(arr, (i1, i2) -> i1.start - i2.start);

        //Sort the intervals based on increasing order of starting time.
        Arrays.sort(arr, Comparator.comparingInt(i -> i.start));
        for (Interval interval : arr) {
            System.out.println(interval);
        }

        List<Interval> intervals = mergeIntervals(arr);
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static List<Interval> mergeIntervals(Interval[] arr) {

        int index = 0;
        List<Interval> result = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            if (arr[index].end >= arr[i].start){
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }else {
                result.add(arr[index]);
                arr[index] = arr[i];
            }
        }
        result.add(arr[index]);
        return result;
    }
}
