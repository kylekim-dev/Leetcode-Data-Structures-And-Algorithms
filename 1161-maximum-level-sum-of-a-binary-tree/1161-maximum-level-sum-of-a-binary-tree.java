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
    public int maxLevelSum(TreeNode root) {
        // Algorithm & DS: Queue, BFS
        // Time: O(N), Space: O(N)
        
        Queue<TreeNode> q = new ArrayDeque<>();
        int level = 1;
        int localLevel = 1;
        int sum = Integer.MIN_VALUE;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            int localSum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                localSum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
            if(localSum > sum) {
                sum = localSum;
                level = localLevel;
            }
            
            localLevel++;
        }
        
        return level;
    }
}