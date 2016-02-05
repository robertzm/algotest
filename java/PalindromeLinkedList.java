/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;
        ListNode rHead = null;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = rHead;
            rHead = slow;
            slow = tmp;
        }
        if(fast.next == null){
            return compare(rHead, slow.next);
        }else{
            return compare(rHead, slow.next.next) && slow.val == slow.next.val;
        }
    }
    public boolean compare(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 != null || head2 != null) return false;
        return true;
    }
}