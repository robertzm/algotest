public class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<Integer>();
        
        s = s.replace(" ", "");
        
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else if(s.charAt(i) == ')'){
                if(st.peek() == null){
                    return 0;
                }
                int tmp = calWoParen(s.substring(st.peek()+1, i));
                if(tmp >= 0){
                    s = s.substring(0, st.peek()) + tmp + s.substring(i+1);
                }else{
                    if(st.peek() >= 1 && s.charAt(st.peek()-1) == '-'){
                        s = s.substring(0, st.peek()) +"0+" + Math.abs(tmp) + s.substring(i+1);
                    }else{
                        s = s.substring(0, st.peek()) +"0" + tmp + s.substring(i+1);
                    }
                }
                i = st.pop()-1;
            }
        }
        return calWoParen(s);
    }
    
    private int calWoParen(String s){
        int result = 0, operator = 0;
        String num = "";
        for(int i = 0; i < s.length(); i ++){
            if(!num.equals("") && !Character.isDigit(s.charAt(i))){
                if(operator == 0){
                    result += Integer.parseInt(num);
                }else{
                    result -= Integer.parseInt(num);
                }
                num = "";
            }
            if(s.charAt(i) == '+'){
                operator = 0;
            }else if(s.charAt(i) == '-'){
                operator = 1;
            }else if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }
        }
        if(!num.equals("")){
            if(operator == 0){
                result += Integer.parseInt(num);
            }else{
                result -= Integer.parseInt(num);
            }
            num = "";
        }
        return result;
    }
}