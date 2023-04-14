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
    public void reorderList(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        Stack<ListNode> s = new Stack<>();

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null){
            s.push(slow);
            slow = slow.next;
        }

        ListNode left = head;

        while (!s.isEmpty()){
            ListNode right = s.pop();
            right.next = left.next;
            left.next = right;

            left = left.next.next;
        }
        
        left.next = null;
    }
}