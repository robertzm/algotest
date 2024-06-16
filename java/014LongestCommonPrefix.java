class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length() ; i++) {
            char t = strs[0].charAt(i);
            for (String st : strs) {
                if (st.length() == i || st.charAt(i) != t) {
                    return sb.toString();
                }
            }
            sb.append(t);
        }
        return sb.toString();
    }
}
