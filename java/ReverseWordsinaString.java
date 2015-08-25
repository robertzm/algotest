public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0 || s.indexOf(" ") == -1){
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i --){
            if(words[i].length() != 0){
                if(result.length() != 0){
                    result = result.append(" ");
                }
                result = result.append(words[i]);
            }
        }
        return result.toString();
    }
}