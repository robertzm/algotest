/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<String> st2 = new Stack<String>();
        List<String> strs= new ArrayList<String>();
        String str = "";
        
        st2.push("");

        while(root != null){
            st2.push(st2.peek() + root.val);
            st.push(root);
            root = root.left;
        }
        while(!st.empty()){
            TreeNode tmp = st.pop();
            str = st2.pop();
            if(tmp.left == null && tmp.right == null){
                strs.add(str);
            }
            if(tmp.right == null){
                continue;
            }else{
                root = tmp.right;
                st.push(root);
                st2.push(str + root.val);
                while(root.left != null){
                    root = root.left;
                    st.push(root);
                    st2.push(st2.peek() + root.val);
                }
                continue;
            }
        }
        double result = 0;
        for(String s: strs){
            result += Integer.parseInt(s);
            if(result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int) result;
    }
}