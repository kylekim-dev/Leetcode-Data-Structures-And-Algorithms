# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # BFS
        # T: O(N)
        # S: O(M)
        
        if not root:
            return root
        
        rightSideValues, q = list(), [root]
        
        while q:
            nodeCount = len(q)
            
            while nodeCount > 0:
                node = q.pop(0)
                nodeCount -= 1
                
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                    
                if nodeCount == 0:
                    rightSideValues.append(node.val)
            
        return rightSideValues
        
        