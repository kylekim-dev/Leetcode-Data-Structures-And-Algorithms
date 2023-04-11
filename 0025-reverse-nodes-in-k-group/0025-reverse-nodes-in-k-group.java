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
        Solution 1. using Stack
        
        Solution 2. using recursion
    
    
    */
    
    // Solution1 with Stack
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode node = dummy.next;
        
        while(node != null){
            stack.push(node);
            node = node.next;
            
            if(stack.size() == k){
                ListNode curr = stack.pop();
                left.next = curr;
                
                while(!stack.isEmpty()){
                    ListNode prev = stack.pop();
                    curr.next = prev;
                    curr = prev;
                }
        
                curr.next = node;
                left = curr;
            }
        }
        
        return dummy.next;
    }
}