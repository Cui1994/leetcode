class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int i=0, j=len-1;
        while (i<=j) {
            int k = (i+j+1)/2;
            if (nums[k] == target) return k;
            if (nums[k] <= nums[j]) {
                if (nums[k] < target && nums[j] >= target) i=k;
                else j=k-1;
            }
            else {
                if (nums[k] > target && nums[i] <= target) j=k-1;
                else i=k;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,1};
        System.out.println(solution.search(nums, 3));
    }
}

// 二分查找的变形，注意边界情况
