import java.util.*;

class Solution {
    public String longestPalindrome(String s) {

        Map<Integer, String> maxToStr = new HashMap<Integer, String>();
        maxToStr.put(0, "");

        int max=0;
        int len = s.length();
        for (int i=0; i<len; i++){
            int j=1;
            int t_max = 1;
            maxToStr.put(t_max, s.substring(i, i+1));
            while (i-j>=0 && i+j<len) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    t_max += 2;
                    maxToStr.put(t_max, s.substring(i-j, i+j+1));
                    j++;
                } else break;
            }
            max = Math.max(max, t_max);
        }

        for (int i=0; i<len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                int j=1;
                int t_max = 2;
                maxToStr.put(t_max, s.substring(i, i+2));
                while(i-j>=0 && i+j+1<len) {
                    if (s.charAt(i-j) == s.charAt(i+j+1)) {
                        t_max += 2;
                        maxToStr.put(t_max, s.substring(i-j, i+j+2));
                        j++;
                    } else break;
                }
                max = Math.max(max, t_max);
            }
        }


        return maxToStr.get(max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = s.longestPalindrome("cbbd");
        System.out.println(a);
    }
}
