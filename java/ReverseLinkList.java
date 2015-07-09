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
        if(head == null || head.next == null)
            return head;
        ListNode newTail = new ListNode(head.val);
        ListNode newHead = reverseList(head.next);
        ListNode tmpHead = newHead;
        while(tmpHead.next != null){
            tmpHead = tmpHead.next;
        }
        tmpHead.next = newTail;
        newTail.next = null;
        return newHead;
    }
}
