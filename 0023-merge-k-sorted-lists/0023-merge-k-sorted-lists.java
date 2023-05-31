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
        
        1 > 1 > 2 > 3 > 4 > 4 > 5 > 6
    
    */
    public ListNode mergeKLists(ListNode[] lists) {
        // Algorithm: Min Heap
        // K = 10^4, N = 500
        // Time: O(N*K*LogK), Space: O(K)
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        
        for(ListNode n : lists) if(n != null) pq.offer(n);
        
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            node.next = curr;
            node = node.next;
            
            if(curr.next != null) pq.offer(curr.next);
        }
        
        return dummy.next;
    }
}