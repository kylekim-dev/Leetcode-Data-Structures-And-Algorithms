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
    
    /*public int maxDepth(TreeNode root, int depth){
        if(root == null) return depth;
        
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }
    
    public int maxDepth(TreeNode root) {
        // Algorithm: DFS, Recursion 
        // Time: O(N) Space: O(N)
        return maxDepth(root, 0);
    }*/
    
    public int maxDepth(TreeNode root) {
        // Algorithm: BFS, Iteration 
        // Time: O(N) Space: O(N)
        int level = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        
        if(root != null) q.add(root);
        
        while(!q.isEmpty()){
            int nodeCount = q.size();
            while(nodeCount > 0){
                TreeNode node = q.poll();
                
                if(node.left != null) q.add(node.left); 
                if(node.right != null) q.add(node.right); 
                
                nodeCount -= 1;
            }
            
            level += 1;
        }
        
        return level;
    }
}