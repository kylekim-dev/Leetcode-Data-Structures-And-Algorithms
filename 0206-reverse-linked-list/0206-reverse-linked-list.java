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
        ListNode left = null;
        ListNode mid = head;
        ListNode right;
        
        while(mid != null){
            right = mid.next;
            mid.next = left;
            left = mid;
            mid = right;
        }
        return left;
    }
}