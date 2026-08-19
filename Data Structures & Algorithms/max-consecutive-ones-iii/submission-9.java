class Solution {
    public int longestOnes(int[] nums, int k) {
        int counter = 0;
        int l = 0;
        int max = 0;
        for(int r=0; r<nums.length; r++) {
            int curr = nums[r];
            if(curr == 0) {
                counter++;
                if(counter > k) {
                    while(nums[l] != 0) {
                        l++;
                    }
                    l = l+1;
                    counter = k;
                }
            }
            max = Math.max(max, (r-l)+1);
        }
        return max;
    }
}