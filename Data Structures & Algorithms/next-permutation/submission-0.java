class Solution {

    public void reverseArray(int[] nums, int first, int last) {
        while(first < last) {
            swap(nums, first, last);
            first++;
            last--;
        }
    }

    public void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) {
            reverseArray(nums, 0, n-1);
            return;
        }

        for(int i= n-1; i>=0; i--) {
            if(nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }
        }
        reverseArray(nums, breakPoint+1, n-1);
    }
}