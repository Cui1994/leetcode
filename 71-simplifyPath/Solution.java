class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        int len = paths.length;
        String res = "";

        for (int i=0; i<len; i++) {
            if (paths[i].equals("") || paths[i].equals(".")) continue;
            else if (paths[i].equals("..")) {
                if (stack.empty()) continue;
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(paths[i]);
            }
        }

        if (stack.empty()) return "/";

        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }

        return res;
    }

}

