public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> qNum = new Stack<Integer>();
        int result, num1, num2;
        for(int i = 0; i < tokens.length; i ++){
            if(Character.isDigit(tokens[i].charAt(tokens[i].length()-1))){
                if(tokens[i].charAt(0) == '*' || tokens[i].charAt(0) == '/'){
                    return 0;
                }
                qNum.push(Integer.parseInt(tokens[i]));
            }else{
                if(qNum.empty()){
                    return 0;
                }else{
                    num2 = qNum.pop();
                }
                if(qNum.empty()){
                    return 0;
                }else{
                    num1 = qNum.pop();
                }
                qNum.push(calculate(num1, num2, tokens[i].charAt(0)));
            }
        }
        if(qNum.empty()){
            return 0;
        }
        result = qNum.pop();
        if(!qNum.empty()){
            return 0;
        }
        return result;
    }
    
    private int calculate(int num1, int num2, char op){
        switch(op){
            case '+':
                if(num1 + num2 < 0){
                    return Math.max(num1 + num2, Integer.MIN_VALUE);
                }else{
                    return Math.min(num1 + num2, Integer.MAX_VALUE);
                }
            case '-':
                if(num1 - num2 < 0){
                    return Math.max(num1 - num2, Integer.MIN_VALUE);
                }else{
                    return Math.min(num1 - num2, Integer.MAX_VALUE);
                }
            case '*':
                if(num1 * num2 < 0){
                    return Math.max(num1 * num2, Integer.MIN_VALUE);
                }else{
                    return Math.min(num1 * num2, Integer.MAX_VALUE);
                }
            case '/':
                if(num2 == 0){
                    return 0;
                }
                if(num1 * num2 < 0){
                    return Math.max(num1 / num2, Integer.MIN_VALUE);
                }else{
                    return Math.min(num1 / num2, Integer.MAX_VALUE);
                }
            default:
                return 0;
        }
    }
}