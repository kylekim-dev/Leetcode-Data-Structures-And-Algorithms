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
        노드중에 오른쪽 자식만 가지고있는 노드가 있니?
        Algorithm & DS: BFS, Queue
    */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        boolean isEnded = false;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(node.left == null) isEnded = true;
                else if(node.left != null && isEnded) return false;
                else q.add(node.left);
                
                if(node.right == null) isEnded = true;
                else if(node != null && isEnded) return false;
                else q.add(node.right);
            }
        }
        
        return true;
    }
}