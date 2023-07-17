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
        7 2 4 3
        5 6 4
        
        3 4 7 0
        4 6 0 1
        
        curr
        
        0 7
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null || l2 != null){
            if(l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            
            if(l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        
        ListNode head = null;
        int carry = 0;
        
        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0){
            ListNode node = new ListNode(carry);
            
            if(!s1.isEmpty()) node.val += s1.pop();
            if(!s2.isEmpty()) node.val += s2.pop();
            
            carry = node.val / 10;
            node.val = node.val % 10;
            
            node.next = head;
            head = node;
        }
        
        return head;
    }
}