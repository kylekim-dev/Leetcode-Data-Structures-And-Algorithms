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
    private boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        else if (a == null && b != null) return false;
        else if (a != null && b == null) return false;
        
        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        // Algorithm:  DFS, Recursion
        // Time: O(N), Space: O(N)
        return isSymmetric(root.left, root.right);
    }
}