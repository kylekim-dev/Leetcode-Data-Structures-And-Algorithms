# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        node = dummy
        carry = 0
        
        while l1 or l2:
            if l1:
                carry += l1.val
                l1 = l1.next
                
            if l2:
                carry += l2.val
                l2 = l2.next
                
            node.next = ListNode(carry % 10)
            node = node.next
            carry = carry // 10
            
        if carry > 0:
            node.next = ListNode(carry)
            
        return dummy.next
                
                
                