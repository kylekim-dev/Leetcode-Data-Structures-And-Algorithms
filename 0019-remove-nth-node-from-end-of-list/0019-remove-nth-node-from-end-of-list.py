# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        k, dummy = 0, ListNode()
        dummy.next = head
        
        while head:
            k += 1
            head = head.next
        
        head = dummy
        
        for i in range(k - n):
            head = head.next
            
        if head.next:
            head.next = head.next.next
        
        return dummy.next