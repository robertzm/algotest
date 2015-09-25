/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;

        ListNode prevNode = head, curNode = head.next;
        while(curNode != null){
            if(curNode.val < prevNode.val){
                ListNode tmp = curNode;
                prevNode.next = curNode.next;
                curNode = prevNode.next;
                head = newHead;
                while(true){
                    if(head.val <= tmp.val && head.next.val >= tmp.val){
                        tmp.next = head.next;
                        head.next = tmp;
                        break;
                    }else{
                        head = head.next;
                    }
                }
            }else{
                prevNode = curNode;
                curNode = curNode.next;
            }
        }
        return newHead.next;
    }
}