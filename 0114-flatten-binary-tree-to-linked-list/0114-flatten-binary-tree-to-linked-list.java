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
    
    TreeNode end = null;
    
    public void flatten(TreeNode root) {
        // Algorithm: Inorder, Recursion
        // Time: O(N), Space: O(N) << Stack 영역, O(1) << Heap 영역
        if(root == null) return;
        
        flatten(root.left);
        
        if(root.left != null){
            end.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        flatten(root.right);
        if(root.right == null) end = root;
    }
}