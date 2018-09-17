class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int i = 0;
        int len = strs.length;
        while (true) {
            char single = ' ';
            for (int j=0; j<len; j++) {
                String strJ = strs[j];
                try {
                    if (single==' ' || strJ.charAt(i) == single) {
                       single = strJ.charAt(i);
                    }
                    else single = ' ';
                }
                catch (Exception e) {
                    single = ' ';
                }
                if (single == ' ') break;
            }
            if (single != ' ') {
                i++;
                res += single;
            }
            else break;
        }
        return res;
    }
}
