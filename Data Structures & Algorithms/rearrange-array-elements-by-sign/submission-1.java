class Solution {
    public int[] rearrangeArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            // Even index should contain positive
            if (i % 2 == 0 && nums[i] < 0) {
                int j = i + 1;

                while (j < nums.length && nums[j] < 0) {
                    j++;
                }

                // Rotate nums[j] to position i
                int temp = nums[j];
                while (j > i) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[i] = temp;
            }

            // Odd index should contain negative
            else if (i % 2 == 1 && nums[i] > 0) {
                int j = i + 1;

                while (j < nums.length && nums[j] > 0) {
                    j++;
                }

                int temp = nums[j];
                while (j > i) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[i] = temp;
            }
        }

        return nums;
    }
}