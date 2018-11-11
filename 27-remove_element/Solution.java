import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = len;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j-1];
                j--;
            } else {
                i++;
            }
        }


        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,2,2,4,5,6};
        System.out.println(solution.removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
}
