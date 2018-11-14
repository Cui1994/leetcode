class Solution {
    public int myAtoi(String str) {
        int i=0;
        int result = 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        if (len == 0) return 0;
        boolean is_negative = false;
        while (i<len && chars[i] == ' ') i++;
        if (i<len && (chars[i] == '+' || chars[i] == '-'))
        {
            if (chars[i] == '-') is_negative = true;
            i++;
        }

        while (i<len && chars[i] <= '9' && chars[i] >= '0') {
            if ((!is_negative) && (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (chars[i] - '0')>7))) return Integer.MAX_VALUE;
            if (is_negative && (result > (0 - Integer.MIN_VALUE/10) || (result == (0-Integer.MIN_VALUE/10) && (chars[i] - '0')>8))) return Integer.MIN_VALUE;
            result = result * 10 + chars[i] - '0';
            i++;
        }

        result = result * (is_negative? -1 : 1);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-01324000"));
    }
}

