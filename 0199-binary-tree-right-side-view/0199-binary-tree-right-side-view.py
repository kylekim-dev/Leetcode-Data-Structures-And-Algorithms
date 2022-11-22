# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        output = list()
        q = [root]

        if not root:
            return output
        
        
        # Iterative BFS 
        while q:
            count = len(q)
            
            while count > 0:
                node = q.pop(0)
                count -= 1

                if count == 0: output.append(node.val)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
                    
                
        
        return output