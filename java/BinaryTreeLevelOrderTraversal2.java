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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<List<Integer>> s = new Stack<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> tmp = new ArrayList<Integer>();
        q.add(root);
        int upper = 1, lower = 0;
        while(q.peek() != null){
            TreeNode cur = q.peek();
            if(cur.left != null){
                q.add(cur.left);
                lower++;
            }
            if(cur.right != null){
                q.add(cur.right);
                lower++;
            }
            tmp.add(cur.val);
            upper--;
            if(upper == 0){
                s.push(tmp);
                tmp = new ArrayList<Integer>();
                upper = lower;
                lower = 0;
            }
            q.remove();
        }
        while(!s.empty()){
            result.add(s.pop());
        }
        return result;
    }
}