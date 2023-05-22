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
    public ListNode reverseList(ListNode head) {
        // Special case...
        if (head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;     // for keeping last node
    }
    
    
    /*
    public ListNode reverseList(ListNode head) {
        //  Algorithm: Iteration
        //  Time: O(N)
        //  Space: O(1)
        ListNode left = null, mid = head, right;
        
        while(mid != null){
            right = mid.next;
            mid.next = left;
            left = mid;
            mid = right;
        }
        
        return left;
    }

    */
}