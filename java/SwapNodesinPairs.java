/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        newHead.next.next = swapPairs(tmp);
        return newHead;
    }
}