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
        f(1)
         f(-2) > f(3) > 3
          f(1)      0   
           f(-1)    -1
    
    */
    
    int max = Integer.MIN_VALUE;
    
    public int postOrder(TreeNode root){
        if(root == null) return 0;
        
        int leftMax = postOrder(root.left);
        int rightMax = postOrder(root.right);
        
        int singlePathMax = Math.max(root.val, Math.max(rightMax + root.val, leftMax + root.val));
        int multiPathMax = Math.max(leftMax + rightMax + root.val, rightMax + root.val);
        
        max = Math.max(max, Math.max(singlePathMax, multiPathMax));
        
        return singlePathMax;
    }
    
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }
}