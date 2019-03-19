class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        boolean[][] state = new boolean[n][n];

        for (int i=n-1; i>=0; i--) {
            state[i][i] = true;
            for (int j=i+1; j<n; j++) {
                if (i+1<n && j-1>0 && i+1 <= j-1) {
                    if (state[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                        state[i][j] = true;
                    }
                    else {
                        state[i][j] = false;
                    }
                }
                else if (j == i+1 && s.charAt(i) == s.charAt(j)) {
                    state[i][j] = true;
                }
            }
        }

        int start = 0;
        int end = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (state[i][j] && j-i > end-start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end+1);
    }

}
