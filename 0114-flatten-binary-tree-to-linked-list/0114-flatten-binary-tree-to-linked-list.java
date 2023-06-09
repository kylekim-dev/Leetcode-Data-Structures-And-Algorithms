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
        if(root == null) return;
        
        flatten(root.left);
        if(root.left != null){
            end.right = root.right;
            //end = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
        
        if(root.right == null) end = root;
    }
}