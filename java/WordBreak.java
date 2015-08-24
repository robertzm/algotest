public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int len = s.length();
        int maxWordLen = maxLength(wordDict);
        boolean[] able = new boolean[len + 1];
        Arrays.fill(able, false);
        able[0] = true;
        
        for(int i = 1; i <= len; i ++){
            for(int j = 1; j <= maxWordLen && j <= i; j ++){
                if(!able[i - j]){
                    continue;
                }
                String word = s.substring(i - j, i);
                if(wordDict.contains(word)){
                    able[i] = true;
                    break;
                }
            }
        }
        return able[len];
    }
    
    private int maxLength(Set<String> wordDict){
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(word.length(), maxLen);
        }
        return maxLen;
    }
}