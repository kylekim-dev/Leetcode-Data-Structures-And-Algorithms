# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
         1
       2     
    4     5
  12   6     7
     8  9  10 
          11
"""

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.diameter = 0
        self.dfs(root)
        return self.diameter
    
    def dfs(self, node):
        # base case:
        if node == None:
            return 0
		# recursive cases
        left_height = self.dfs(node.left)
        right_height = self.dfs(node.right)
        self.diameter = max(self.diameter,left_height + right_height )
        return max(left_height,right_height) + 1

        return min(self.dfsMin(node.left), self.dfsMin(node.right)) + 1
    
    