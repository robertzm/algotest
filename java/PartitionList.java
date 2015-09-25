/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTail = left;
        ListNode rightTail = right;
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
                head = head.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
                head = head.next;
                rightTail.next = null;
            }
        }
        leftTail.next = right.next;
        return left.next;
    }
}