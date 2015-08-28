/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode tmpOld = head;
        RandomListNode tmpNew = newHead;
        int i = 0;
        HashMap<RandomListNode, Integer> hm = new HashMap<RandomListNode, Integer>();
        
        while(tmpOld != null){
            hm.put(tmpOld, i);
            RandomListNode t = new RandomListNode(tmpOld.label);
            tmpNew.next = t;
            tmpNew = tmpNew.next;
            tmpOld = tmpOld.next;
            i++;
        }
        tmpNew.next = null;
        tmpNew = newHead.next;
        tmpOld = head;
        while(tmpOld != null){
            if(tmpOld.random != null){
                int j = hm.get(tmpOld.random);
                RandomListNode tmp = newHead.next;
                while(j-- > 0){
                    tmp = tmp.next;
                }
                tmpNew.random = tmp;
            }else{
                tmpNew.random = null;
            }
            tmpNew = tmpNew.next;
            tmpOld = tmpOld.next;
        }
        return newHead.next;
    }
}