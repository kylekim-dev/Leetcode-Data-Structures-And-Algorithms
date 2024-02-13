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
        /*
            Algorithms & DS: #BFS, #Queue
            Time: O(N), Extra Space: O(1)
         */

        Queue<TreeNode> q = new LinkedList<>();
        int max = Integer.MIN_VALUE, maxLevel = -1;
        int level = 1;
        
        q.offer(root);

        while (!q.isEmpty()){
            int sum = 0;
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                sum += node.val;
            }

            if(sum > max){
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        
        return maxLevel;
    }
}