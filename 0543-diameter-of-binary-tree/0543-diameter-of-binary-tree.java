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
    int longest = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        
        return longest;
    }
    
    public int recur(TreeNode root){
        if(root == null)
            return 0;
        
        int leftMax = recur(root.left);
        int rightMax = recur(root.right);
        
        longest = Math.max(longest, leftMax + rightMax);
        
        return Math.max(leftMax, rightMax) + 1;
    }
}