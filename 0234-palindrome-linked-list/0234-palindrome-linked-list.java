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
    /*
              p c
        1 2 3 4 5 4 3 2 1
        
              p c
        1 2 3 4 4 3 2 1
        
    */
    public boolean isPalindrome(ListNode head) {
        // Algorithm: Stack, Time: O(N), Space: O(1)
        ListNode prev = null, temp = null;
        ListNode slower = head, faster = head;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            
            temp = slower.next;
            slower.next = prev;
            prev = slower;
            slower = temp;
        }
        
        if (faster != null) slower = slower.next; // 홀수개일때
        
        while(slower != null){
            if (prev.val != slower.val) return false;
            slower = slower.next;
            prev = prev.next;
        }

        return true;
    }
}