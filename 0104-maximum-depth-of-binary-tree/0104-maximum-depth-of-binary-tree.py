# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Algorithm: DFS
T: O(N)
S: O(N)
'''

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth = 0

        if not root:
            return depth
        
        q = [root]
        # dfs
        while q:
            num = len(q)
            
            while num > 0:
                node = q.pop(0)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                num -= 1
            
            depth += 1
        
        
        return depth
            
        