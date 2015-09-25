/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head;
        int i = 1;
        while(head.next != null){
            head = head.next;
            i++;
        }
        head.next = newHead;
        k = i - k % i;
        while(k-- > 0){
            head = head.next;
        }
        newHead = head.next;
        head.next = null;
        return newHead;
    }
}