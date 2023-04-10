/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode x = dummy;
        ListNode y = x.next;
        ListNode z = y.next;
        
        while(x.next != null && x.next.next != null){
            y = x.next;
            z = y.next;
            
            x.next = z;
            y.next = z.next;
            z.next = y;
            
            x = x.next.next;
        }
        
        return dummy.next;
    }
}