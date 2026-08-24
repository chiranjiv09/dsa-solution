class MedianFinder {

    PriorityQueue<Integer> minHeap; // to keep all the big elements
    PriorityQueue<Integer> maxHeap; // to keep all the small element


    public MedianFinder() {
        minHeap = new PriorityQueue<>();        
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void reverseElementOfHeaps() {
        int temp = minHeap.poll();
        minHeap.offer(maxHeap.poll());
        maxHeap.offer(temp);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            reverseElementOfHeaps();
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}