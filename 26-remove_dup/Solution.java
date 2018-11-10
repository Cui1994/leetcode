class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i=0;
        boolean is_cont = true;
        for(int j=1; j<len; j++) {
            for (int k=0; k<j; k++) {
                if (nums[k] == nums[j]) {
                    is_cont = false;
                }
            }
            if (is_cont) {
                nums[i + 1] = nums[j];
                i++;
            }
            is_cont = true;
        }
        return i+1;
    }
}


/*
此处未仔细审题数组为排序数组。
*/
