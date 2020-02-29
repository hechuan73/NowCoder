package sword_offers;

import java.util.PriorityQueue;

/**
 * Use a small top heap and a big top heap to store a half of numbers respectively.
 * The big top heap stores the first half smaller elements, and the small top heap stores the second half bigger ones.
 * If total number is even, the two heaps stores n/2 elements respectively.
 * If total number is old, the big top heap stores n/2 + 1 elements.
 *
 * @author hechuan
 */
public class FindMedianInDataStream_62 {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
    private boolean even = true;
    public void Insert(Integer num) {
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }

        even = !even;
    }

    public Double GetMedian() {
        return maxHeap.isEmpty() ? 0 : (even ? (minHeap.peek()+maxHeap.peek())/2d : Double.valueOf(maxHeap.peek()));
    }
}
