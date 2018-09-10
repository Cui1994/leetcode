import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();

        int i=0, j=0, ans=0;

        while (i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
        // int max = 0;
        // for (int i=0; i < s.length(); i++) {

        //     String subStr = "";
        //     Boolean isContinue = true;

        //     for (int j=i; j < s.length(); j++) {
        //         if (!isContinue) break;

        //         char ch = s.charAt(j);
        //         if (subStr.indexOf(ch) == -1) {
        //             subStr += ch;
        //         } else {
        //             break;
        //         }
        //         max = max>subStr.length()? max: subStr.length();

        //     }

        // }

        // return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int len = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}


/*
最优解：

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

相较于滑动窗口，优化滑动窗口引入了HashMap储存索引，当发现滑动窗口内存在重复字符串时直接将i移动到重复字符串后位继续计算，省去了i的重复移动。

这里需要注意，字符串的indexOf并不是O(1)运算，因此刚开始的暴力解法实际上为O(n3)

*/
