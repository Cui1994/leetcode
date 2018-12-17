class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;

        while (low<=high) {
            mid = low + ((high-low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                if (nums[high] >= target || nums[mid] > nums[high]) low = mid + 1;
                else high = mid-1;
            }
            else {
                if (nums[low] <= target || nums[mid] < nums[low]) high = mid-1;
                else low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{4,5,6,7,8,1,2,3};

        System.out.println(solution.search(nums, 8));

    }
}
