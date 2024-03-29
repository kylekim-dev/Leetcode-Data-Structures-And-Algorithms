/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        Edge Case1:
        root = [5, 4, 6, null, null, 3, 7]
                5
              /  \
             4    6
                 / \
                3   7
    */
    
    TreeNode prev;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        // Algorithm: Recursion and Inorder
        // Time: O(N), Space: O(N)
        if(root == null) return true;
        
        isValid = isValid && isValidBST(root.left);
        
        if(prev != null && prev.val >= root.val) return false;
        else prev = root;
        
        return isValid && isValidBST(root.right);
    }
}