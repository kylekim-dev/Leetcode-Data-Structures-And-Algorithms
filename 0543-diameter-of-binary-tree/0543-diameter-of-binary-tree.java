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
        /*
            Algorithms & DS: PostOrder Traversal
            Time: O(N), Space: O(N)
        */
        postOrder(root);
        
        return longest;
    }
    
    public int postOrder(TreeNode root){
        if(root == null)
            return 0;
        
        int leftMax = postOrder(root.left);
        int rightMax = postOrder(root.right);
        
        longest = Math.max(longest, leftMax + rightMax);
        
        return Math.max(leftMax, rightMax) + 1;
    }
}