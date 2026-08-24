class Solution {
    public int maxProfit(int[] prices) {
        int sufMax = prices[prices.length-1];
        int max = 0;
        for(int i = prices.length-2; i>=0; i--) {
            if(prices[i] > sufMax) {
                sufMax = prices[i];
            } else {
                max = Math.max(max, sufMax - prices[i]);
            }
        }
        return max;

    }
}
