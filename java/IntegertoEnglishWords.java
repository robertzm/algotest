public class Solution {
    public String numberToWords(int num) {
        String str = "";
        if(num == 0){
            return "Zero";
        }
        int tmp = num % 1000;
        num /= 1000;
        if(tmp > 0){
            str = unitString(tmp);
        }
        if(num == 0){
            return str;
        }
        tmp = num % 1000;
        num /= 1000;
        if(tmp > 0){
            if(!str.equals("")){
                str = " " + str;
            }
            str = unitString(tmp) + " Thousand" + str;
        }
        if(num == 0){
            return str;
        }
        tmp = num % 1000;
        num /= 1000;
        if(tmp > 0){
            if(!str.equals("")){
                str = " " + str;
            }
            str = unitString(tmp) + " Million" + str;
        }  
        if(num == 0){
            return str;
        }
        tmp = num % 1000;
        num /= 1000;
        if(tmp > 0){
            if(!str.equals("")){
                str = " " + str;
            }
            str = unitString(tmp) + " Billion" + str;
        }
        if(num == 0){
            return str;
        }
        tmp = num % 1000;
        num /= 1000;
        if(tmp > 0){
            if(!str.equals("")){
                str = " " + str;
            }
            str = unitString(tmp) + " Trillion" + str;
        }
        return str;
    }
    
    public String unitString(int num){
        String str = "";
        int digit = num/100;
        if(digit > 0){
            str = match(digit) + " " + match(100);
        }
        num = num % 100;
        if(num == 0){
        }else if(num <= 20){
            if(!str.equals("")){
                str = str + " ";
            }
            str = str + match(num);
        }else{
            if(!str.equals("")){
                str = str + " ";
            }
            if(num % 10 == 0){
                str = str + match(num);
            }else{
                str = str + match(num - num%10) + " " + match(num%10);
            }
        }
        return str;
    }
    
    public String match(int num){
        switch(num){
            case 1: 
                return "One";
            case 2:
                return "Two";
            case 3: 
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
            case 100:
                return "Hundred";
            default:
                return "";
        }
    }
}