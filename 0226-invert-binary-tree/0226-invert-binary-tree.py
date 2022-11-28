# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # BFS
        # T: O(N)
        # S: O(M) (M < N)
        
        if not root:
            return root
            
        q = [root]
        
        while q:
            node = q.pop(0)
            
            temp = node.left
            node.left = node.right
            node.right = temp
            
            if node.left:
                q.append(node.left)
            
            if node.right:
                q.append(node.right)
                
            
        return root
        
        
        
            
            

        

            
        
        