/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head; head = newHead;
        ListNode flag;
        m--;n--;
        while(m > 0){
            head = head.next;
            m--;n--;
        }
        flag = head;
        head = head.next;
        while(n-- > 0){
            ListNode tmp = head.next;
            head.next = head.next.next;
            tmp.next = flag.next;
            flag.next = tmp;
        }
        return newHead.next;
    }
}