/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(0);
        ListNode res = tail;
        int a, b, c = 0;
        while(true){
            a = (l1 != null)? l1.val: 0;
            b = (l2 != null)? l2.val: 0;
            tail.val = (a + b + c)%10;
            c = (a+b+c)/10;
            l1 = (l1 != null)? l1.next: l1;
            l2 = (l2 != null)? l2.next: l2;
            if(l1 != null || l2 != null || c != 0){
                tail.next = new ListNode(0);
            }else{
                break;
            }
            tail = tail.next;
        }
        return res;
    }
}