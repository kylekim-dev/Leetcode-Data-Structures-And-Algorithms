# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # BFS
        # T: O(N)
        # S: O(M)
        levelOrderArray, q = list(), [root]
        
        if not root:
            return root
        
        while q:
            nodeCount = len(q)
            levelValues = list()
            
            while nodeCount > 0:
                node = q.pop(0)
                levelValues.append(node.val)
                
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                
                nodeCount -= 1
                
            levelOrderArray.append(levelValues)
            
        return levelOrderArray
        
        
        
        
            
            