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
    private int maxDepth(TreeNode node, int depth){
        if(node == null)
            return depth;
        
        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }
    
    public int maxDepth(TreeNode root) {
        /*
            Algorithms & DS: DFS
            Time: O(N), Space: O(1)
        */
        
        return maxDepth(root, 0);
    }
}