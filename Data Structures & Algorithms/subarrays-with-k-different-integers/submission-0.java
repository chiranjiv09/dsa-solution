class Solution {
    
    public int equalsOrLessKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l =0;
        int count = 0;
        
        for(int r=0; r<nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.size() > k){
                int left = nums[l];
                if(map.get(left) == 1) {
                    map.remove(left);
                } else{
                    map.put(left, map.get(left)-1);
                }
                l++;
            }
            count += (r-l)+1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return equalsOrLessKDistinct(nums, k) - equalsOrLessKDistinct(nums, k-1);
    }
}