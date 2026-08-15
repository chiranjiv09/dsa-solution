class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int each: nums) {
            map.put(each, map.getOrDefault(each, 0) +1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry.getKey());
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int index = 0;
        int[] result = new int[k];
        while(!queue.isEmpty()) {
            result[index++] = queue.poll();
        }
        return result;
    }
}