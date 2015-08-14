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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int upper = 1, lower = 0;
        while(q.peek() != null){
            if(q.peek().left != null){
                q.add(q.peek().left);
                lower ++;
            }
            if(q.peek().right != null){
                q.add(q.peek().right);
                lower ++;
            }
            tmp.add(q.peek().val);
            upper--;
            if(upper == 0){
                result.add(tmp);
                upper = lower;
                lower = 0;
                tmp = new ArrayList<Integer>();
            }
            q.remove();
        }
        return result;
    }
}