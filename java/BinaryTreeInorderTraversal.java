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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            if(st.empty()){
                break;
            }else{
                result.add(st.peek().val);
                root = st.pop().right;
            }
        }
        return result;
        
    }
}