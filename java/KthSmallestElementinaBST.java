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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0){
            return 0;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root != null){
            st.push(root);
            root = root.left;
        }
        while(k-->0){
            if(!st.empty()){
                TreeNode tmp = st.pop();
                int val = tmp.val;
                tmp = tmp.right;
                while(tmp != null){
                    st.push(tmp);
                    tmp = tmp.left;
                }
                if(k == 0){
                    return val;
                }
            }else{
                return 0;
            }
        }
        return 0;
    }
}