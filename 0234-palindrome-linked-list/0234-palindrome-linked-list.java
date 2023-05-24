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
          
    // 1 2 3 4 5 4 3 2 1
    /*
        r(1, 1)
         r(2, 3)
          r(3, 5)
           r(4, 3) <<
            r(5, 1)
        
        
        1 2 2 1
        
        r(1, 1)
         r(2, 2)
          r(2, null)
        
    */
    
    ListNode right;
    
    public boolean isPalindrome(ListNode left, ListNode faster){
        if(faster == null || faster.next == null) {
            right = left;
            return true;   
        }
        
        boolean temp = isPalindrome(left.next, faster.next.next);
        if(faster.next.next != null) right = right.next;
        return temp && left.val == right.val;
    }
    
    public boolean isPalindrome(ListNode head) {
        return isPalindrome(head, head);
    }
    
    /*public boolean isPalindrome(ListNode head) {
        // Algorithm: Stack, Time: O(N), Space: O(N)
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
    }*/
}