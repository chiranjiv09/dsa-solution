class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int plus = 0;
        int minus = 1;

        for(int each: nums) {
            if(each < 0) {
                result[minus] = each;
                minus +=2;
            } else {
                result[plus] = each;
                plus += 2;
            }
        }
        return result;
    }
}