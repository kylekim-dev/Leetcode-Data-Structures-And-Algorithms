from typing import Optional
from pip import List
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
# Kyle's solution, Brute-Force
# Time Complexity: O(N)
# Space Complexity: O(1)

def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if head.next == None:
        return None
    
    slower, faster = head, head
    shadow = slower
    
    while faster:
        if faster.next == None:
            shadow.next = shadow.next.next
            return head
        elif faster.next.next == None:
            slower.next = slower.next.next
            return head

        shadow = slower
        slower = slower.next
        faster = faster.next.next
        
    return head

head = [1,3,4,7,1,2,6]
output = deleteMiddle(head)