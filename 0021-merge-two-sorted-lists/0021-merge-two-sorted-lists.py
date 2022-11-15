# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
N: length of list1
M: length of list2

T: O(N + M)
S: O(N + M)
"""
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        
        headNode = mList = ListNode()
        
        while list1 and list2:
            if list1.val < list2.val:
                mList.next = list1
                list1 = list1.next
            else:
                mList.next = list2
                list2 = list2.next
            
            mList = mList.next
    
        if list1:
            mList.next = list1
        
        if list2:
            mList.next = list2

        return headNode.next
    