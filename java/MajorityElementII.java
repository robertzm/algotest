public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int a = 0, b = 1, ca = 0, cb = 0;
        for(int num: nums){
            if(num == a){
                ca ++;
            }else if(num == b){
                cb ++;
            }else if(ca == 0){
                a = num;
                ca = 1;
            }else if(cb == 0){
                b = num;
                cb = 1;
            }else{
                ca --;
                cb --;
            }
        }
        ca = 0;
        cb = 0;
        for(int num: nums){
            if(num == a){
                ca ++;
            }else if(num == b){
                cb ++;
            }
        }
        if(ca > (nums.length/3)){
            result.add(a);
        }
        if(cb > (nums.length/3)){
            result.add(b);
        }
        return result;
    }
}