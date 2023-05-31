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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Algorithm: Linked List
        // Time: O(N), Space: O(1)
        /*
            9,9,9,9,9,9,9>1
            9,9,9,9,
        */
        ListNode dummy = new ListNode(-1, l1);
        int carry = 0;
        
        while(l1 != null || l2 != null){
            if(l1.next == null && l2 != null && l2.next != null){
                l1.next = l2.next;
                l2.next = null;
            }
            
            if(l2 != null) l1.val += l2.val;
            
            l1.val += carry;
            carry = l1.val >= 10 ? 1 : 0;
            l1.val %= 10;
            
            if(l1.next == null && carry > 0) l1.next = new ListNode();
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}