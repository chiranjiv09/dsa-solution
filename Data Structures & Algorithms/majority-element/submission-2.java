class Solution {
    public int majorityElement(int[] nums) {
        int curr = -1;
        int count = 0;
        for(int each: nums) {
            if(count == 0){
                curr = each;
            }
            if(each == curr) {
                count++;
            } else {
                count--;
            }
        }
        return curr;
    }
}