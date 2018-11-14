class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 0) return 0;

        int i=0, j=len-1, maxArea=0;

        while (i<j) {
            maxArea = Math.max(maxArea, (j-i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
    }
}
