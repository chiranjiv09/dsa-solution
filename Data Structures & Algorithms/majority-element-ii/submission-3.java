class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for(int each: nums) {
            if(count1 == 0 && el2 != each) {
                el1 = each;
                count1++;
            } else if(count2 == 0 && el1 != each) {
                el2 = each;
                count2++;
            } else if(el1 == each) {
                count1++;
            } else if(el2 == each) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(el1 != Integer.MIN_VALUE) {
            int c1 = 0;
            for(int each: nums) {
                if(each == el1) {
                    c1++;
                }
            }
            if(c1 > nums.length/3) {
                list.add(el1);
            }
        }

        if(el2 != Integer.MIN_VALUE) {
            int c2 = 0;
            for(int each: nums) {
                if(each == el2) {
                    c2++;
                }
            }
            if(c2 > nums.length/3) {
                list.add(el2);
            }
        }
        return list;

    }
}