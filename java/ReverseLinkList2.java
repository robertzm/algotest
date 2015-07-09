/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        newHead.next = null;
        ListNode tmpNode;
        head = head.next;
        while(head != null){
            tmpNode = new ListNode(head.val);
            tmpNode.next = newHead;
            newHead = tmpNode;
            head = head.next;
        }
        return newHead;
    }
}
