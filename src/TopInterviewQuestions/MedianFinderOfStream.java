package TopInterviewQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinderOfStream {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;
    /** initialize your data structure here. */
    public MedianFinderOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }

    public static void main(String[] args) {

        double median1;
        MedianFinderOfStream median = new MedianFinderOfStream();
        median.addNum(1);
        median.addNum(2);
        median1 = median.findMedian();
        System.out.println(median1);
        median.addNum(3);
        median1 = median.findMedian();
        System.out.println(median1);
    }
}
