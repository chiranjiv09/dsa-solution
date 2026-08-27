// Pascal formula:
// next = current * (rowNum - i) / (i + 1)
//
// Example row 4:
// 1 → 1*4/1 = 4 → 4*3/2 = 6 → 6*2/3 = 4 → 4*1/4 = 1
class Solution {
    public List<Integer> findEachRow(int rowNum) {
        List<Integer> row = new ArrayList<>();
        int each = 1;
        row.add(each);
        for (int i = 0; i < rowNum; i++) {
            each = each * (rowNum - i) / (i + 1);
            row.add(each);
        }
        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(findEachRow(i));
        }
        return result;
    }
}