public class Solution {
    public String addBinary(String a, String b) {
        // adjust to addBinary(String long, String short)
        if(a.length() >= b.length())
            return addString(a, b);
        else
            return addString(b, a);
    }
    
    // add binary string from last bit to first bit of string b
    String addString(String a, String b){
        String res = a;
        for(int i = 0; i < b.length(); i ++){
            res = addBit(res.substring(0, res.length()-i), b.charAt(b.length()-1-i)) + res.substring(res.length() - i, res.length());
        }
        return res;        
    }
    
    // add bit to binary string a
    String addBit(String a, char b){
        if(b == '0')
            return a;
        else
            return addOne(a);
    }
    
    // add one to binary string a
    String addOne(String a){
        String res = "";
        int i;
        // check for last "0" bit in string a
        for(i = a.length()-1; i >=0; i--){
            if(a.charAt(i) == '0')
                break;
        }
        if(i <= 0){
            res += "1";
        }else{
            res = a.substring(0,i) + "1";
        }  
        while(i + 1 < a.length()){
            res += "0";
            i++;    
        }
        return res;
    }
}