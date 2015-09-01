/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        HashMap<Integer, ListNode> hm = new HashMap<Integer, ListNode>();
        int i = 0, j = 0;
        ListNode newHead = head;
        while(newHead != null){
            hm.put(i, newHead);
            newHead = newHead.next;
            i++;
        }
        i--;
        newHead = head;
        while(j < i){
            hm.get(j).next = hm.get(i);
            j++;
            if(j == i){
                break;
            }
            hm.get(i).next = hm.get(j);
            i--;
        }
    }
}