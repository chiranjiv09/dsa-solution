/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    //[(0,40),(5,10),(15,20)]
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for(Interval each: intervals) {
            if(!pq.isEmpty()) {
                if(pq.peek() > each.start) {
                    pq.offer(each.end);
                } else {
                    pq.poll();
                    pq.offer(each.end);
                }
            } else {
                pq.offer(each.end);
            }
        }

        return pq.size();

    }
}
