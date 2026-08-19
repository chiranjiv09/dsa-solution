class Solution {
    public int lengthOfLongestSubstring(String s) {
                // Stores each character and its most recent index.
        Map<Character, Integer> map = new HashMap<>();
        // Left side of our sliding window
        int l = 0;
        int maxLen = 0;
        // r represents the right side of the sliding window
        for (int r = 0; r < s.length(); r++) {

            // Get the current character
            char ch = s.charAt(r);

            /*
             * If we have seen this character before AND
             * its previous occurrence is inside our current window,
             * we have a duplicate.
             *
             * So move l to one position after the previous occurrence.
             *
             * Example:
             * s = "abcabc"
             *
             * When r = 3, ch = 'a'
             * previous 'a' was at index 0
             *
             * Move l:
             * l = 0 + 1 = 1
             *
             * Current window becomes "bca"
             */
            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            }

            // Update the latest position of the current character
            map.put(ch, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        // Return the length of the longest substring
        // containing no duplicate characters.
        return maxLen;
    }
}
