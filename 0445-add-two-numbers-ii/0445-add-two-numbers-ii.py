# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        s1 = []
        s2 = []
        
        while l1 is not None or l2 is not None:
            if l1 is not None:
                s1.append(l1.val)
                l1 = l1.next
            
            if l2 is not None:
                s2.append(l2.val)
                l2 = l2.next
        
        head = None
        carry = 0
        
        while s1 or s2 or carry > 0:
            node = ListNode(carry)
            
            if s1:
                node.val += s1.pop()
            
            if s2:
                node.val += s2.pop()
            
            carry = node.val // 10
            node.val = node.val % 10
            
            node.next = head
            head = node
        
        return head
        