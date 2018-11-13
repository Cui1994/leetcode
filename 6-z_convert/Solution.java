import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int nowRow = 0;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        boolean isReverse = true;
        for (char aChar : chars) {
            rows.get(nowRow).append(aChar);

            if (nowRow==0 || nowRow==numRows-1) {
                isReverse = !isReverse;
            }

            nowRow += isReverse? -1:1;
        }

        String result = "";
        for (StringBuilder row : rows) {
            result += row.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
