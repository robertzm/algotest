/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, tail = head.next.next, oddTail = head, evenTail = head.next;
        int cnt = 1;
        while(tail != null){
            if(cnt++ % 2 == 1) {
                oddTail.next = tail; 
                oddTail = oddTail.next;
            }else{
                evenTail.next = tail;
                evenTail = evenTail.next;
            }
            tail = tail.next;
        }
        oddTail.next = even;
        evenTail.next = null;
        return odd;
    }
}