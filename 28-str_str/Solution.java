class Solution {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int sublen = needle.length();
        for (int i=0; i<=len; i++) {
            if (i+sublen>len) {
                return -1;
            }
            else {
                boolean isDone = true;
                for (int j=0; j<sublen; j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) isDone=false;
                }
                if (isDone) return i;
            }
        }

        return -1;
    }
}
