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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        TreeNode result = null;
        dfs(root, p, pStack);
        dfs(root, q, qStack);
        if(pStack.isEmpty() || qStack.isEmpty()){
            return null;
        }
        while(!pStack.isEmpty() && !qStack.isEmpty()){
            TreeNode pTmp = pStack.pop();
            TreeNode qTmp = qStack.pop();
            if(pTmp == qTmp){
                result = pTmp;
            }else{
                break;
            }
        }
        return result;
    }
    
    private boolean dfs(TreeNode root, TreeNode node, Stack<TreeNode> stack){
        if(root == null){
            return false;
        }else if(root == node){
            stack.push(root);
            return true;
        }
        if(dfs(root.left, node, stack)){
            stack.push(root);
            return true;
        }else if(dfs(root.right, node, stack)){
            stack.push(root);
            return true;
        }
        return false;
    }
    
}