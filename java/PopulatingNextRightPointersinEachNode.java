/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null){
            return;
        }
        TreeLinkNode upper = root;
        while(upper.left != null){
            TreeLinkNode lowerHead = upper.left;
            TreeLinkNode lower = lowerHead;
            while(true){
                lower.next = upper.right;
                if(upper.next != null){
                    lower.next.next = upper.next.left;
                    lower = lower.next.next;
                    upper = upper.next;
                }else{
                    break;
                }
            }
            upper = lowerHead;
        }
    }
}