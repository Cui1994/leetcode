import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 4) return result;

        for (int m=0; m<len-3; m++) {
            if (m!=0 && nums[m] == nums[m-1]) continue;
            for (int i=m+1; i<len - 2; i++) {
                int j = i + 1, k = len - 1;
                if (i != m+1 && nums[i] == nums[i - 1]) continue;
                while (j < k) {
                    if (k != len - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    } else if (j != i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                    } else if (target-nums[m]-nums[i] == nums[j] + nums[k]) {
                        List<Integer> newRes = new ArrayList<>();
                        newRes.add(nums[m]);
                        newRes.add(nums[i]);
                        newRes.add(nums[j]);
                        newRes.add(nums[k]);
                        result.add(newRes);
                        j++;
                        k--;
                    } else {
                        int sum = target - nums[m] - nums[i];
                        if (nums[j] + nums[k] < sum) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,0,0};
        System.out.println(solution.fourSum(nums, 0));
    }
}
