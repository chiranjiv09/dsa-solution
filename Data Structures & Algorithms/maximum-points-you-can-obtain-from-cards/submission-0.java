// Start:   [1, 79, 80, 1, 1, 1, 200, 1]    → 3 Left  = 160
// Step 1:  [1, 79] + [1]                    → 2 Left + 1 Right = 81
// Step 2:  [1] + [200, 1]                   → 1 Left + 2 Right = 202
// Step 3:  [] + [1, 200, 1]                 → 0 Left + 3 Right = 202  → MAX = 202

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int r = cardPoints.length-1;
        int leftSum = 0;
        for(int i =0; i<k; i++) {
            leftSum += cardPoints[i];
        }
        int rightSum = 0;
        int maxSum = leftSum;

        while(k > 0){
            leftSum -= cardPoints[k-1];
            rightSum += cardPoints[r];
            maxSum = Math.max(maxSum, leftSum+rightSum);
            r--;
            k--;            
        }
        return maxSum;
    }
}