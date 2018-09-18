import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> strMap = new HashMap<Character, Character>();
        strMap.put(')', '(');
        strMap.put(']', '[');
        strMap.put('}', '{');

        int len = s.length();
        Stack<Character> st = new Stack<Character>();

        for (int i=0; i<len; i++) {
            char chI = s.charAt(i);
            if (!strMap.containsKey(chI)) st.push(chI);
            else if (st.isEmpty() || !(strMap.get(chI) == st.pop())) return false;
        }

        if (!st.isEmpty()) return false;

        return true;

    }
}
