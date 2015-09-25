/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA!=null && tmpB!=null){
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        while(tmpA != null && headA!=null){
            headA = headA.next;
            tmpA = tmpA.next;
        }        
        while(tmpB != null && headB!= null){
            headB = headB.next;
            tmpB = tmpB.next;
        }
        while(headA != null && headB != null){
            if(headB == headA){
                return headA;
            }else{
                headB = headB.next;
                headA = headA.next;
            }
        }
        return null;
    }
}