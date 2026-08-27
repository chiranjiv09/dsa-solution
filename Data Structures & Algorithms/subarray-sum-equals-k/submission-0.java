// map = {0 → 1}
// sum = 0
// count = 0

//         nums[i]
//            ↓
//       sum += nums[i]
//            ↓
//      sum - k = needed
//            ↓
//    ┌─────────────────┐
//    │ needed in map ? │
//    └────────┬────────┘
//         YES ↓
//    count += frequency
//            ↓
//    map[sum]++
//            ↓
//        next i

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i=0; i< nums.length; i++) {
            int curr = nums[i];
            sum += curr;
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}