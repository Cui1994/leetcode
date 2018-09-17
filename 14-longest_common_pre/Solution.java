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


/*
最优解


public static String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if(count != 0){
            prefix = strs[0];
        }
        for(int i=0; i<count; i++){
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

同样也是n2复杂度，不过相比较而言更加优雅。
*/
