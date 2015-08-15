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
        if(headA == null || headB == null){
            return null;
        }
        HashMap<ListNode, Integer> hm = new HashMap<ListNode, Integer>();
        
        while(headA != null){
            hm.put(headA, 1);
            headA = headA.next;
        }
        while(headB != null){
            if(hm.containsKey(headB)){
                return headB;
            }else{
                hm.put(headB, 1);
                headB = headB.next;
            }
        }
        return null;
    }
}