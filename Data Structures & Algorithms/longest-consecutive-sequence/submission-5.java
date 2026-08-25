class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int each: nums) {
            set.add(each);
        }
        int max = 0;
        for(int each: set) {
            int curr = each;
            if(!set.contains(curr-1)) {
                int count = 0;
                while(set.contains(curr)) {
                    count++;
                    curr++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
