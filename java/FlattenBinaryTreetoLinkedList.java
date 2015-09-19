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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        if(root.left != null){
            flatten(l);
            root.left = null;
            root.right = l;
            while(l.right != null){
                l = l.right;
            }
            flatten(r);
            l.right = r;
        }else{
            flatten(r);
        }
    }
}