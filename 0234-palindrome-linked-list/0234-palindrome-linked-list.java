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
            Algorithms & DS: Stack
            Time: O(N), Extra Space: O(N)
         */

        Stack<ListNode> s = new Stack<>();
        ListNode node = head;

        while (node != null){
            s.push(node);
            node = node.next;
        }

        int n = s.size();
        node = head;

        for(int i = 0; i < n / 2; i++){
            if(node.val != s.pop().val){
                return false;
            }

            node = node.next;
        }
        
        return true;
    }
}