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
        /*
            Algorithms & DS: Two Pointer (Turtle & Rabbit)
            Time: O(N), Extra Space: O(1)
        */
        ListNode slower = head, faster = head;
        ListNode prev = null, temp = null;
        
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