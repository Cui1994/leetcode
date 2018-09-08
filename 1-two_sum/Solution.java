class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]+ nums[j] == target) {
                    int[] result = new int[]{i, j};
                    return result;
                }
            }
        }
        return new int[]{};
    }
}

/*
最优解：

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}

思想：借助hash表储存目标及其index的对应关系，以空间换时间的方法。
*/
