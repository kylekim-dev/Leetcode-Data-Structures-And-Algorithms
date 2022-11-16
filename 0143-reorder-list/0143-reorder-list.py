# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        prev, curr = None, slow
        
        while curr:
            temp = curr.next
            curr.next = prev 
            prev = curr
            curr = temp
            
        first, second = head, prev
        
        '''
        1 2 3
        
        4 3
        
        1 4 2 3 3
        
        '''
        while second:
            if first.next and not second.next:
                first.next = None
            
            fNext = first.next
            sNext = second.next
            first.next = second
            second.next = fNext
            first = fNext
            second = sNext
            
        
        return head
            
            