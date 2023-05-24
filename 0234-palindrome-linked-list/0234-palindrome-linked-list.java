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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode slower, faster;
        slower = faster = head;
        
        while(faster != null && faster.next != null){
            s.push(slower);
            slower = slower.next;
            faster = faster.next.next;
        }
        
        if(faster != null) s.push(slower);
        
        while(!s.isEmpty()){
            if(s.pop().val != slower.val) return false;
            slower = slower.next;
        }
        
        return true;
    }
}