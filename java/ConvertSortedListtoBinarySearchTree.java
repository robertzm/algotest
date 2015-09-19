/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> tmp1 = new ArrayList<Integer>();
        while(head != null){
            tmp1.add(head.val);
            head = head.next;
        }
        int[] tmp = new int[tmp1.size()];
        int j = 0;
        for(Integer i: tmp1){
            tmp[j++] = i;
        }
        int left = 0, right = tmp.length-1;
        int mid = left + (right - left + 1)/2;
        TreeNode root = new TreeNode(tmp[mid]);
        root.left = findNext(tmp, left, mid-1);
        root.right = findNext(tmp, mid+1, right);
        return root;
    }
    public TreeNode findNext(int[] tmp, int left, int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(tmp[left]);
        }else{
            int mid = left + (right - left + 1)/2;
            TreeNode root = new TreeNode(tmp[mid]);
            root.left = findNext(tmp, left, mid-1);
            root.right = findNext(tmp, mid+1, right);
            return root;
        }
    }
}