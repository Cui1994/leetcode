import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<len-2; i++) {
            int j=i+1, k=len-1;
            if (nums[i]>0) break;
            if (i!=0 && nums[i] == nums[i-1]) continue;
            while (j<k) {
                if (k!=len-1 && nums[k]==nums[k+1]) {
                    k--;
                }
                else if (j!=i+1 && nums[j] == nums[j-1]) {
                    j++;
                }
                else if (0-nums[i] == nums[j]+nums[k]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    result.add(res);
                    j++;
                    k--;
                }
                else if (0-nums[i]>nums[j]+nums[k]) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(solution.threeSum(nums).toArray()));
    }
}


/*
时间复杂度分析：
sort是一个nlogn复杂度排序
程序算法每次枚举一个i，之后jk采用双指针遍历一次，总体复杂度为n2
*/
