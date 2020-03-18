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
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(1,3);
        arr[1]=new Interval(2,6);
        arr[2]=new Interval(8,10);
        arr[3]=new Interval(15,18);

//        Old Fashined Comparator
//        Arrays.sort(arr, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval i1, Interval i2) {
//                return i1.start - i2.start;
//            }
//        });

//      lambda expression Comparator
//      Arrays.sort(arr, (i1, i2) -> i1.start - i2.start);

        Arrays.sort(arr, Comparator.comparingInt(i -> i.start));

        List<Interval> intervals = mergeIntervals(arr);
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    private static List<Interval> mergeIntervals(Interval[] arr) {

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
