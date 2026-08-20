class Solution {

            //  getSmallerEqualsPairs(goal)
            //   ┌─────────────────┐
            //   │ sum < goal      │
            //   │ sum == goal  ←──┼── We want this
            //   └─────────────────┘
            //            -
            //  getSmallerEqualsPairs(goal-1)
            //   ┌─────────────────┐
            //   │ sum < goal      │
            //   └─────────────────┘
            //            =
            //      sum == goal
    public int  getSmallerEqualsPairs(int[] nums, int goal) {
        if(goal < 0) return 0;
        int l=0;
        int sum = 0;
        int count = 0;

        for(int r=0; r<nums.length; r++) {
            sum += nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return getSmallerEqualsPairs(nums, goal) - getSmallerEqualsPairs(nums, goal-1);
    }
}