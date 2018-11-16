import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        Integer numAbs = null;
        int res = 0;

        for (int i=0; i<len-2; i++) {
            int j=i+1, k=len-1;
            if (i!=0 && nums[i] == nums[i-1]) continue;
            while (j<k) {
                if (k!=len-1 && nums[k]==nums[k+1]) {
                    k--;
                }
                else if (j!=i+1 && nums[j] == nums[j-1]) {
                    j++;
                }
                else if (target-nums[i] == nums[j]+nums[k]) {
                    return target;
                }
                else {
                    int sum = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(target-sum);
                    if (numAbs == null || abs < numAbs) {
                        res = sum;
                        numAbs = abs;
                    }
                    if (target>sum) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,1};
        System.out.println(solution.threeSumClosest(nums, 0));
    }
}
