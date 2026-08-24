class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            int each = nums[i];
            if(map.containsKey(target - each)) {
                return new int[]{map.get(target-each), i};
            } else {
                map.put(each, i);
            }
        }
        return new int[]{-1, -1};
    }
}
