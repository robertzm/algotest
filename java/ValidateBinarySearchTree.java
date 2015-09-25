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
    public boolean isValidBST(TreeNode root) {
        return helper(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }
    
    public boolean helper(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if((long)root.val <= min || (long)root.val >= max){
            return false;
        }else{
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
        
    }
}