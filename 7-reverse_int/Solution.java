class Solution {
    public int reverse(int x) {
        int result = 0;
        int is_negative = 1;
        if (x<0) {
            x = -x;
            is_negative = -1;
        }
        while (x>0) {
            int num = x % 10;
            if (Long.valueOf(result) * 10 + num > 2147483647) return 0;
            result = result * 10 + num;
            x /= 10;
        }

        return result * is_negative;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.reverse(1534236469);
        System.out.println(a);
    }

}


/*
最优解
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}


错误：
1. 正数和负数的溢出绝对值不同，需要分别判断。
2. 每次转换为Long型消耗大量时间，只需要在每次累加前将result和MAX_VALUE/10的值进行对比即可。
3. 不需要区分正负数，负数取余还是负数。
*/
