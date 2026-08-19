class Solution {
    public int totalFruit(int[] fruits) {
        int l= 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int r=0; r< fruits.length; r++) {
            int curr = fruits[r];
            map.put(curr, map.getOrDefault(curr, 0)+1);

            while(map.size() > 2) {
                int leftCurr = fruits[l];
                int freq = map.get(leftCurr);
                if(freq == 1) {
                    map.remove(leftCurr);
                } else {
                    map.put(leftCurr, freq-1);
                }
                l++;
            }
            max = Math.max(max, (r-l)+1);
        }
        return max;
    }
}