// Last updated: 7/9/2026, 10:06:28 AM
class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } 
            else if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } 
            else if (ch == '#') {
                result.append(result.toString());
            } 
            else if (ch == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}