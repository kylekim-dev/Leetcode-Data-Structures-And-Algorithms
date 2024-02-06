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
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
            Algorithms & DS: Recursive
            Time: O(N), Extra Space: O(1)
         */
        List<Integer> answer = new ArrayList<>();

        inorder(root, answer);
        
        return answer;
    }
    

    private void inorder(TreeNode node, List<Integer> answer){
        if(node == null)
            return;

        inorder(node.left, answer);
        answer.add(node.val);
        inorder(node.right, answer);
    }
}