import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i=len-2;

        while (i>=0) {
            if (nums[i+1] > nums[i]) break;
            i--;
        }

        if (i>=0) {
            for (int j=len-1; j>i; j--) {
                if (nums[j] > nums[i]) {
                    int a = nums[j];
                    nums[j] = nums[i];
                    nums[i] = a;
                    break;
                }
            }
        }

        i++;
        int j=len-1;
        while (i<=j) {
            int a = nums[j];
            nums[j] = nums[i];
            nums[i] = a;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}


/*
时间复杂度：o(n) 空间复杂度 o(1)
*/
