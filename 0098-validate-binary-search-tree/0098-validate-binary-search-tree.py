# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
input: [7,4,15,1,10,14,17]

        7
    4       15
  1  10    14  17
  
output: [1, 4, 10, 7, 14, 15, 17]
  
Inorder로 읽었을때 오름차순으로 정렬된다면 BST!

T: O(2N)
S: O(N)
"""
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        output = []
        
        self.inorder(root, output)
        
        for i in range(1, len(output)):
            print(output[i - 1], output[i])
            if output[i - 1] >= output[i]:
                return False
            
        return True
        
    def inorder(self, node, output):
        if node is None:
            return

        self.inorder(node.left, output)
        output.append(node.val)
        self.inorder(node.right, output)