public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if(size == 0){
            return "";
        }
        int i, j;
        for(i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(j = 1; j < size; j ++){
                if(i >= strs[j].length() || c != strs[j].charAt(i)){
                    break;
                }
            }
            if(j != size){
                break;
            }
        }
        if(i == 0){
            return "";
        }else{
            return strs[0].substring(0,i);
        }
    }
}