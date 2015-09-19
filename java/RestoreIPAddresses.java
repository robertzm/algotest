public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() < 4){
            return result;
        }
        
        int p0 = (s.charAt(0) == '0')? 1: s.length()-3;
        for(int i = 1; i <= p0; i ++){
            int num0 = Integer.parseInt(s.substring(0,i));
            if(num0 > 255){
                break;
            }
            int p1 = (s.charAt(i) == '0')? i+1: s.length()-2;
            for(int j = i+1; j <= p1; j++){
                int num1 = Integer.parseInt(s.substring(i, j));
                if(num1 > 255){
                    break;
                }
                int p2 = (s.charAt(j) == '0')? j+1: s.length()-1;
                for(int k = j+1; k <= p2; k++){
                    int num2 = Integer.parseInt(s.substring(j,k));
                    if(num2 > 255){
                        break;
                    }
                    if(s.charAt(k) == '0' && k != s.length()-1){
                        continue;
                    }
                    if(s.length() - k > 3){
                        continue;
                    }
                    int num3 = Integer.parseInt(s.substring(k));
                    if(num3 > 255){
                        continue;
                    }else{
                        String str = num0+"."+num1+"."+num2+"."+num3;
                        if(!result.contains(str)){
                            result.add(str);
                        }
                    }
                }
            }
        }
        return result;
    }
}