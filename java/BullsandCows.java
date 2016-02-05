public class Solution {
    public String getHint(String secret, String guess) {
            if(secret.length() == 0 || guess.length() != secret.length()) return "Error";
            int bulls = 0, cows = 0;
            char[] seChar = secret.toCharArray();
            char[] guChar = guess.toCharArray();
            int[] seCtr = new int[10];
            int[] guCtr = new int[10];
            
            for(int i = 0; i < seChar.length; i++){
                if(seChar[i] == guChar[i]){
                    bulls++;
                }else{
                    seCtr[seChar[i] - '0']++;
                    guCtr[guChar[i] - '0']++;
                }
            }
            for (int i = 0; i < 10; i ++){
                cows += Math.min(seCtr[i], guCtr[i]);
            }
            return bulls+"A"+cows+"B";
    }
}