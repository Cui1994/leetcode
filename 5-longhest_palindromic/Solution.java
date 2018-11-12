class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int i;
        int len = s.length();

        for (i=0; i<len; i++) {
            String target = "" + s.charAt(i);
            int k=i-1;
            int j=i+1;
            while (j<len && s.charAt(i) == s.charAt(j)){
                target = target + s.charAt(j);
                j++;
            }
            while (k>=0 && j<len) {
                if (s.charAt(k) == s.charAt(j)) {
                    target = s.charAt(k) + target + s.charAt(j);
                    k--;
                    j++;
                }
                else break;
            }

            if (target.length() > result.length()) {
                result = target;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abbc"));
    }
}



// 自认为解法无误，时间复杂度为n2

/*
中心扩展法
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}
*/
