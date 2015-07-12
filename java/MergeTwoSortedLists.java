/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newList = (l1.val <= l2.val)? l1: l2;
        ListNode tmpNode = new ListNode(0);
        if(newList == l1){
            while(true){
                while(l1.next != null && l1.next.val <= l2.val){
                    l1 = l1.next;
                }
                tmpNode = l1.next;
                l1.next = l2;
                l1 = tmpNode;
                if(l1 == null)
                    break;
                while(l2.next != null && l2.next.val <= l1.val){
                    l2 = l2.next;
                }
                tmpNode = l2.next;
                l2.next = l1;
                l2 = tmpNode;
                if(l2 == null)
                    break;
            }
        }else{
            while(true){
                while(l2.next != null && l2.next.val <= l1.val){
                    l2 = l2.next;
                }
                tmpNode = l2.next;
                l2.next = l1;
                l2 = tmpNode;
                if(l2 == null)
                    break;
                    
                while(l1.next != null && l1.next.val <= l2.val){
                    l1 = l1.next;
                }
                tmpNode = l1.next;
                l1.next = l2;
                l1 = tmpNode;
                if(l1 == null)
                    break;
            }            
        }
        return newList;
    }
}