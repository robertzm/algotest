/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        while(true){
            node.val = node.next.val;
            if(node.next.next != null){
                node = node.next;
            }else{
                node.next = null;
                break;
            }
        }
    }
}