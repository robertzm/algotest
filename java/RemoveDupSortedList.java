/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = head;
        int cur = head.val;
        while(head.next != null){
            if(head.next.val == cur){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
            cur = head.val;
        }
        return newHead;
    }
}