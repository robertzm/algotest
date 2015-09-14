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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        while(true){
            while(root != null){
                st.push(root);
                result.add(root.val);
                root = root.left;
            }
            if(st.empty()){
                return result;
            }else{
                root = st.pop().right;
            }
        }
    }
}