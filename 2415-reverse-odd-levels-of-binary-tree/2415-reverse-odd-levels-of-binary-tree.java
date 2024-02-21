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
        [0,1,2,0,0,0,0,1,2,3,4,5,6,7,7]
        [0,2,1,0,0,0,0,7,7,6,5,4,3,2,1]
    */
    public TreeNode reverseOddLevels(TreeNode root) {
        /*
            Algorithms & DS: #BFS, #Queue
            Time: O(N), Extra Space: O(N)
         */

        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();

            Stack<TreeNode> stack = new Stack<>();

            for(int i = 0; i < size; i++){
                TreeNode rightNode = q.poll();

                if(rightNode.left != null) q.offer(rightNode.left);
                if(rightNode.right != null) q.offer(rightNode.right);

                // Odd level
                if(level % 2 == 1){
                    if(i < size / 2){
                        stack.push(rightNode);
                    }
                    else {
                        TreeNode leftNode = stack.pop();
                        int temp = rightNode.val;
                        rightNode.val = leftNode.val;
                        leftNode.val = temp;
                    }
                }
            }
            level++;
        }

        return root;
    }
}