class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long each = 1;
        result.add((int)each);
        for(int i=0; i<rowIndex; i++) {
            each *= rowIndex-i;
            each /= i+1;
            result.add((int)each);
        }
        return result;
    }
}