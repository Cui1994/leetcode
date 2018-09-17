import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        strMap.put("I", 1);
        strMap.put("V", 5);
        strMap.put("X", 10);
        strMap.put("L", 50);
        strMap.put("C", 100);
        strMap.put("D", 500);
        strMap.put("M", 1000);

        Map<String, Integer> doubleStrMap = new HashMap<String, Integer>();
        doubleStrMap.put("IV", 4);
        doubleStrMap.put("IX", 9);
        doubleStrMap.put("XL", 40);
        doubleStrMap.put("XC", 90);
        doubleStrMap.put("CD", 400);
        doubleStrMap.put("CM", 900);

        int len = s.length();
        int i=0, j=1, res=0;
        while(i<len) {
            String strI = s.charAt(i) + "";
            if (j>=len || !doubleStrMap.containsKey(strI + s.charAt(j))) {
                res += strMap.get(strI);
            }
            else {
                res += doubleStrMap.get(strI + s.charAt(j));
                i++;
                j++;
            }
            i++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.romanToInt("IV");
        System.out.println(res);
    }
}
