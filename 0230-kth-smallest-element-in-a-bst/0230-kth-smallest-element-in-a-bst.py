# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Algorithm: inorder traversal with intertor
        # N = k
        # T: O(N)
        # S: O(M)
        
        current = root
        stack = []
        
        while True:
            if current:
                stack.append(current)
                current = current.left
                
            elif stack:
                current = stack.pop()
                if k == 1:
                    return current.val
                
                k -= 1
                current = current.right
            else:
                break
                
        return -1
        
        