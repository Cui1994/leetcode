class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x!=0) return false;

        int reverseNum = 0;
        while(x>reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        if (x == reverseNum || x == reverseNum / 10) return true;
        else return false;
    }

    //     String str = x + "";
    //     int len = str.length();

    //     for (int i=0; i<len/2; i++) {
    //         if (str.charAt(i) != str.charAt(len-i-1)) return false;
    //     }

    //     return true;
    // }
}



/*
转换为字符串需要消耗额外空间，非字符方法为了防止反转数字出现整形溢出问题，可以只反转一半数字。
*/
